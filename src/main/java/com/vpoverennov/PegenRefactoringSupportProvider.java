package com.vpoverennov;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.vpoverennov.psi.PegenRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PegenRefactoringSupportProvider extends RefactoringSupportProvider {
  @Override
  public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
    return (elementToRename instanceof PegenRule);
  }
}
