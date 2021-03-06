// This is a generated file. Not intended for manual editing.
package com.vpoverennov.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.vpoverennov.psi.PegenTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vpoverennov.psi.*;

public class PegenSqbAtomImpl extends ASTWrapperPsiElement implements PegenSqbAtom {

  public PegenSqbAtomImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PegenVisitor visitor) {
    visitor.visitSqbAtom(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PegenVisitor) accept((PegenVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PegenAlt> getAltList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PegenAlt.class);
  }

}
