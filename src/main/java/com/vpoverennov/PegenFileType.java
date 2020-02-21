package com.vpoverennov;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class PegenFileType extends LanguageFileType {
    public static final PegenFileType INSTANCE = new PegenFileType();

    private PegenFileType() {
        super(PegenLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Pegen file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Pegen language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "gram";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PegenIcons.FILE;
    }
}