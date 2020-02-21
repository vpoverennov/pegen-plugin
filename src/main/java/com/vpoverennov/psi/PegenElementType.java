package com.vpoverennov.psi;

import com.intellij.psi.tree.IElementType;
import com.vpoverennov.PegenLanguage;
import org.jetbrains.annotations.*;

public class PegenElementType extends IElementType {
    public PegenElementType(@NotNull @NonNls String debugName) {
        super(debugName, PegenLanguage.INSTANCE);
    }
}