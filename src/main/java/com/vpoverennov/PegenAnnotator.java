package com.vpoverennov;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.vpoverennov.psi.PegenFile;
import com.vpoverennov.psi.PegenNamedAtom;
import com.vpoverennov.psi.PegenRule;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;


public class PegenAnnotator implements Annotator {
    public static final String[] KNOWN_TOKEN_NAMES = {
            "ENDMARKER",
            "TYPE_COMMENT",
            "NEWLINE",
            "NAME",
            "NUMBER",
            "STRING",
            "INDENT",
            "DEDENT",
            "OP",
            "ASYNC",
            "AWAIT",
    };

    public static boolean isKnownTokenName(String name) {
        return Arrays.asList(KNOWN_TOKEN_NAMES).contains(name);
    }

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof PegenNamedAtom)
            annotatePegenNamedAtom((PegenNamedAtom) element, holder);
    }

    public void annotatePegenNamedAtom(@NotNull final PegenNamedAtom namedAtom, @NotNull AnnotationHolder holder) {
        String name = namedAtom.getName();
        if (name == null)
            return;
        if (isKnownTokenName(name))
            return;
        List<PegenRule> rules = PegenUtil.findRules((PegenFile) namedAtom.getContainingFile(), name);
        if (!rules.isEmpty())
            return;
        Annotation unresolvedRule = holder.createErrorAnnotation(namedAtom, "Unresolved rule name");
        unresolvedRule.setTextAttributes(PegenSyntaxHighlighter.BAD_CHARACTER);
        unresolvedRule.registerFix(new PegenCreateRuleQuickFix(name));
    }
}
