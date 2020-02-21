package com.vpoverennov.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.vpoverennov.psi.PegenAtomElement;
import org.jetbrains.annotations.NotNull;

public abstract class PegenAtomElementImpl extends ASTWrapperPsiElement implements PegenAtomElement {
    public PegenAtomElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}