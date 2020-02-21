// This is a generated file. Not intended for manual editing.
package com.vpoverennov.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PegenVisitor extends PsiElementVisitor {

  public void visitAction(@NotNull PegenAction o) {
    visitPsiElement(o);
  }

  public void visitAlt(@NotNull PegenAlt o) {
    visitPsiElement(o);
  }

  public void visitMetaRule(@NotNull PegenMetaRule o) {
    visitPsiElement(o);
  }

  public void visitNamedAtom(@NotNull PegenNamedAtom o) {
    visitAtomElement(o);
  }

  public void visitParenAtom(@NotNull PegenParenAtom o) {
    visitPsiElement(o);
  }

  public void visitRule(@NotNull PegenRule o) {
    visitNamedElement(o);
  }

  public void visitSqbAtom(@NotNull PegenSqbAtom o) {
    visitPsiElement(o);
  }

  public void visitAtomElement(@NotNull PegenAtomElement o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull PegenNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
