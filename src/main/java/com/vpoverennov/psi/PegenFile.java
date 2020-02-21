package com.vpoverennov.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.vpoverennov.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PegenFile extends PsiFileBase {
    public PegenFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PegenLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PegenFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Pegen File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
