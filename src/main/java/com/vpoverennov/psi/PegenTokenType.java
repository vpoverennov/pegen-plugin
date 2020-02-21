package com.vpoverennov.psi;

import com.intellij.psi.tree.IElementType;
import com.vpoverennov.PegenLanguage;
import org.jetbrains.annotations.*;

public class PegenTokenType extends IElementType {
    public PegenTokenType(@NotNull @NonNls String debugName) {
        super(debugName, PegenLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "PEGEN:" + super.toString();
    }
}