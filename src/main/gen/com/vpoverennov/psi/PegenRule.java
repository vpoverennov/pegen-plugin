// This is a generated file. Not intended for manual editing.
package com.vpoverennov.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PegenRule extends PegenNamedElement {

  @NotNull
  List<PegenAlt> getAltList();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
