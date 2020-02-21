package com.vpoverennov;

import com.intellij.lang.Language;

public class PegenLanguage extends Language {
    public static final PegenLanguage INSTANCE = new PegenLanguage();

    private PegenLanguage() {
        super("Pegen");
    }
}