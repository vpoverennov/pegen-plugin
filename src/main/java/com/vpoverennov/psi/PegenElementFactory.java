package com.vpoverennov.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.vpoverennov.PegenFileType;

public class PegenElementFactory {
    public static PegenFile createFile(Project project, String text) {
        String name = "dummy.Pegen";
        return (PegenFile) PsiFileFactory.getInstance(project).createFileFromText(name, PegenFileType.INSTANCE, text);
    }

    public static PegenRule createRule(Project project, String name) {
        final PegenFile file = createFile(project, String.format("%s: fake_atom", name));
        return (PegenRule) file.getFirstChild();
    }

    public static PegenRule createRule(Project project, String name, String value) {
        final PegenFile file = createFile(project, String.format("%s: %s", name, value));
        return (PegenRule) file.getFirstChild();
    }

    public static PegenNamedAtom createNamedAtom(Project project, String name) {
        final PegenFile file = createFile(project, String.format("fake_rule: %s", name));
        return (PegenNamedAtom) file.getFirstChild().getLastChild().getFirstChild();
    }

    public static PsiElement createNEWLINE(Project project) {
        final PegenFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

}