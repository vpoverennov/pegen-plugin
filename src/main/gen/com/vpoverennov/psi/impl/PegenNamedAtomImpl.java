// This is a generated file. Not intended for manual editing.
package com.vpoverennov.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.vpoverennov.psi.PegenTokenTypes.*;
import com.vpoverennov.psi.*;
import com.intellij.psi.PsiReference;

public class PegenNamedAtomImpl extends PegenAtomElementImpl implements PegenNamedAtom {

  public PegenNamedAtomImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PegenVisitor visitor) {
    visitor.visitNamedAtom(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PegenVisitor) accept((PegenVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getName() {
    return PegenPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return PegenPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiReference getReference() {
    return PegenPsiImplUtil.getReference(this);
  }

}
