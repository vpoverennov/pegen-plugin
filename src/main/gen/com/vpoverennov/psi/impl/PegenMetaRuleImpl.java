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

public class PegenMetaRuleImpl extends ASTWrapperPsiElement implements PegenMetaRule {

  public PegenMetaRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PegenVisitor visitor) {
    visitor.visitMetaRule(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PegenVisitor) accept((PegenVisitor)visitor);
    else super.accept(visitor);
  }

}
