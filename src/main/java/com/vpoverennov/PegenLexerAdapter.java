package com.vpoverennov;

import com.intellij.lexer.FlexAdapter;

public class PegenLexerAdapter extends FlexAdapter {
    public PegenLexerAdapter() {
        super(new PegenLexer(null));
    }
}