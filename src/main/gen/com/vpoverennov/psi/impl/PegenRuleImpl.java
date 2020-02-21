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

public class PegenRuleImpl extends PegenNamedElementImpl implements PegenRule {

  public PegenRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PegenVisitor visitor) {
    visitor.visitRule(this);
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

  @Override
  public String getName() {
    return PegenPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return PegenPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return PegenPsiImplUtil.getNameIdentifier(this);
  }

}
