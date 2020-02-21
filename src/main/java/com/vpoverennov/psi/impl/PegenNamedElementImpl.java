package com.vpoverennov.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.vpoverennov.psi.PegenNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class PegenNamedElementImpl extends ASTWrapperPsiElement implements PegenNamedElement {
    public PegenNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}