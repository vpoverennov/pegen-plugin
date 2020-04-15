package com.vpoverennov;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import com.vpoverennov.psi.PegenElementFactory;
import com.vpoverennov.psi.PegenFile;
import com.vpoverennov.psi.PegenRule;
import com.vpoverennov.psi.PegenTokenTypes;
import org.jetbrains.annotations.NotNull;

class PegenCreateRuleQuickFix extends BaseIntentionAction {
    private String key;

    PegenCreateRuleQuickFix(String key) {
        this.key = key;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create rule";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Pegen rules";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return file instanceof PegenFile;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> createRule(project, (PegenFile) file));
    }

    private void createRule(final Project project, final PegenFile pegenFile) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            ASTNode lastChildNode = pegenFile.getNode().getLastChildNode();
            if (lastChildNode != null && !lastChildNode.getElementType().equals(PegenTokenTypes.NEWLINE) && !lastChildNode.getElementType().equals(PegenTokenTypes.NL))
                pegenFile.getNode().addChild(PegenElementFactory.createNEWLINE(project).getNode());
            PegenRule rule = PegenElementFactory.createRule(project, key, "''");
            pegenFile.getNode().addChild(rule.getNode());
            ((Navigatable) rule.getLastChild().getNavigationElement()).navigate(true);
            FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }
}