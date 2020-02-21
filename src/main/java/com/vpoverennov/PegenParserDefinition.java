package com.vpoverennov;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import com.vpoverennov.parser.PegenParser;
import com.vpoverennov.psi.*;
import org.jetbrains.annotations.NotNull;

public class PegenParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE, TokenType.NEW_LINE_INDENT, PegenTokenTypes.NL);
    public static final TokenSet COMMENTS = TokenSet.create(PegenTokenTypes.LINE_COMMENT);
    public static final TokenSet STRINGS = TokenSet.create(PegenTokenTypes.STRING);

    public static final IFileElementType FILE = new IFileElementType(PegenLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new PegenLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() { return WHITE_SPACES; }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new PegenParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new PegenFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return PegenTokenTypes.Factory.createElement(node);
    }
}