package com.vpoverennov;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.vpoverennov.psi.PegenTokenTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PegenSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey OPERATOR =
            createTextAttributesKey("Pegen_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey RULE_NAME =
            createTextAttributesKey("Pegen_RULE_NAME", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NAMED_ATOM =
            createTextAttributesKey("Pegen_NAMED_ATOM", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("Pegen_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("Pegen_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("Pegen_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] RULE_NAME_KEYS = new TextAttributesKey[]{RULE_NAME};
    private static final TextAttributesKey[] NAMED_ATOM_KEYS = new TextAttributesKey[]{NAMED_ATOM};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PegenLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(PegenTokenTypes.VBAR)) {
            return OPERATOR_KEYS;
        } else if (tokenType.equals(PegenTokenTypes.RULE_NAME)) {
            return RULE_NAME_KEYS;
        } else if (tokenType.equals(PegenTokenTypes.NAMED_ATOM)) {
            return NAMED_ATOM_KEYS;
        } else if (tokenType.equals(PegenTokenTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(PegenTokenTypes.LINE_COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTER_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}