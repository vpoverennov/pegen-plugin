// This is a generated file. Not intended for manual editing.
package com.vpoverennov.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PegenAlt extends PsiElement {

  @Nullable
  PegenAction getAction();

  @NotNull
  List<PegenNamedAtom> getNamedAtomList();

  @NotNull
  List<PegenParenAtom> getParenAtomList();

  @NotNull
  List<PegenSqbAtom> getSqbAtomList();

}
