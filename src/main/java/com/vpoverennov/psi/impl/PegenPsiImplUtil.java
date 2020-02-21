package com.vpoverennov.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.vpoverennov.PegenReference;
import com.vpoverennov.psi.*;

public class PegenPsiImplUtil {
    public static PsiReference getReference(PegenNamedAtom element) {
        ASTNode nameNode = element.getNode().findChildByType(PegenTokenTypes.NAME);
        if (nameNode != null) {
            String text = nameNode.getText();
            return new PegenReference(element, new TextRange(0, text.length()));
        } else {
            return null;
        }
    }

    public static String getName(PegenRule element) {
        ASTNode nameNode = element.getNode().findChildByType(PegenTokenTypes.RULE_NAME);
        return nameNode != null ? nameNode.getText() : null;
    }

    public static String getName(PegenNamedAtom element) {
        ASTNode nameNode = element.getNode().findChildByType(PegenTokenTypes.NAME);
        return nameNode != null ? nameNode.getText() : null;
    }

    public static PsiElement setName(PegenRule element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(PegenTokenTypes.RULE_NAME);
        if (nameNode != null) {
            PegenRule rule = PegenElementFactory.createRule(element.getProject(), newName);
            ASTNode newKeyNode = rule.getFirstChild().getNode();
            element.getNode().replaceChild(nameNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement setName(PegenNamedAtom element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(PegenTokenTypes.NAME);
        if (nameNode != null) {
            PegenNamedAtom named_atom = PegenElementFactory.createNamedAtom(element.getProject(), newName);
            ASTNode newNameNode = named_atom.getFirstChild().getNode();
            element.getNode().replaceChild(nameNode, newNameNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(PegenRule element) {
        ASTNode nameNode = element.getNode().findChildByType(PegenTokenTypes.RULE_NAME);
        return nameNode != null ? nameNode.getPsi() : null;
    }
}