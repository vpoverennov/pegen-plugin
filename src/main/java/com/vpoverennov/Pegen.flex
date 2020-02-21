package com.vpoverennov;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.vpoverennov.psi.PegenTokenTypes;
import com.intellij.psi.TokenType;

%%

%class PegenLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

NEWLINE=\n\r|\r\n|\n|\r
WHITE_SPACE=[\ \t\f]
TDQSTRING=\"\"\"
TSQSTRING=\'\'\'
DQSTRING=\"[^\"\n\r]*\"
SQSTRING='[^'\n\r]*'
IDENTIFIER=[\p{XID_Start}_][\p{XID_Continue}]*
NUMBER=[\d]+
LINE_COMMENT="#"[^\r\n]*{NEWLINE}

%{
    int parenlev = 0;
%}

%state IN_TDQSTRING
%state IN_TSQSTRING
%state AWAITING_META_NAME

%%

<IN_TDQSTRING> {
    . {  }
    \n {  }
    {TDQSTRING} { yybegin(YYINITIAL); return PegenTokenTypes.STRING; }
}

<IN_TSQSTRING> {
    . {  }
    \n {  }
    {TSQSTRING} { yybegin(YYINITIAL); return PegenTokenTypes.STRING; }
}

<AWAITING_META_NAME> {
    {IDENTIFIER} { yybegin(YYINITIAL); return PegenTokenTypes.META_NAME; }
    . { yybegin(YYINITIAL); }
}

<YYINITIAL> {
    {LINE_COMMENT} { return PegenTokenTypes.LINE_COMMENT; }
    
    ^{WHITE_SPACE}+ { return TokenType.NEW_LINE_INDENT; }
    {WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }
    
    ^{NEWLINE} { return PegenTokenTypes.NL; }
    {NEWLINE} { return parenlev > 0 ? PegenTokenTypes.NL : PegenTokenTypes.NEWLINE; }

    ^"@" { yybegin(AWAITING_META_NAME); return PegenTokenTypes.AT; }
    ^{IDENTIFIER} { return parenlev > 0 ? PegenTokenTypes.NAME : PegenTokenTypes.RULE_NAME; }
    {IDENTIFIER} { return PegenTokenTypes.NAME; }
    {NUMBER} { return PegenTokenTypes.NUMBER; }
    {TDQSTRING} { yybegin(IN_TDQSTRING); }
    {TSQSTRING} { yybegin(IN_TSQSTRING); }
    {DQSTRING} { return PegenTokenTypes.STRING; }
    {SQSTRING} { return PegenTokenTypes.STRING; }
    
    "$" { return PegenTokenTypes.DOLLAR_SIGN; }
    
    "{" { parenlev += 1; return PegenTokenTypes.LBRACE; }
    "}" { parenlev -= 1; return PegenTokenTypes.RBRACE; }
    "(" { parenlev += 1; return PegenTokenTypes.LPAREN; }
    ")" { parenlev -= 1; return PegenTokenTypes.RPAREN; }
    "[" { parenlev += 1; return PegenTokenTypes.LSQB; }
    "]" { parenlev -= 1; return PegenTokenTypes.RSQB; }
    
    "@" { return PegenTokenTypes.AT; }
    ":" { return PegenTokenTypes.COLON; }
    "|" { return PegenTokenTypes.VBAR; }
    "=" { return PegenTokenTypes.EQUAL; }
    "+" { return PegenTokenTypes.PLUS; }
    "*" { return PegenTokenTypes.STAR; }
    "~" { return PegenTokenTypes.CUT; }
    "!" { return PegenTokenTypes.NOT; }
    "&" { return PegenTokenTypes.AMPER; }
    "?" { return PegenTokenTypes.QUESTION_MARK; }
    "." { return PegenTokenTypes.DOT; }
    
    
    
//     OTHER OPS
//    "!=" { return PegenTokenTypes.OP; }
    "%" { return PegenTokenTypes.OP; }
    "%=" { return PegenTokenTypes.OP; }
//    "&" { return PegenTokenTypes.OP; }
//    "&=" { return PegenTokenTypes.OP; }
//    "(" { return PegenTokenTypes.OP; }
//    ")" { return PegenTokenTypes.OP; }
//    "*" { return PegenTokenTypes.OP; }
    "**" { return PegenTokenTypes.OP; }
    "**=" { return PegenTokenTypes.OP; }
    "*=" { return PegenTokenTypes.OP; }
//    "+" { return PegenTokenTypes.OP; }
//    "+=" { return PegenTokenTypes.OP; }
    "," { return PegenTokenTypes.OP; }
    "-" { return PegenTokenTypes.OP; }
    "-=" { return PegenTokenTypes.OP; }
    "->" { return PegenTokenTypes.OP; }
//    "." { return PegenTokenTypes.OP; }
    "..." { return PegenTokenTypes.OP; }
    "/" { return PegenTokenTypes.OP; }
    "//" { return PegenTokenTypes.OP; }
    "//=" { return PegenTokenTypes.OP; }
    "/=" { return PegenTokenTypes.OP; }
//    ":" { return PegenTokenTypes.OP; }
    ":=" { return PegenTokenTypes.OP; }
    ";" { return PegenTokenTypes.OP; }
    "<" { return PegenTokenTypes.OP; }
    "<<" { return PegenTokenTypes.OP; }
    "<<=" { return PegenTokenTypes.OP; }
    "<=" { return PegenTokenTypes.OP; }
//    "=" { return PegenTokenTypes.OP; }
    "==" { return PegenTokenTypes.OP; }
    ">" { return PegenTokenTypes.OP; }
    ">=" { return PegenTokenTypes.OP; }
    ">>" { return PegenTokenTypes.OP; }
    ">>=" { return PegenTokenTypes.OP; }
//    "@" { return PegenTokenTypes.OP; }
//    "@=" { return PegenTokenTypes.OP; }
//    "[" { return PegenTokenTypes.OP; }
//    "]" { return PegenTokenTypes.OP; }
    "^" { return PegenTokenTypes.OP; }
    "^=" { return PegenTokenTypes.OP; }
//    "{" { return PegenTokenTypes.OP; }
//    "|" { return PegenTokenTypes.OP; }
    "|=" { return PegenTokenTypes.OP; }
//    "}" { return PegenTokenTypes.OP; }
//    "~" { return PegenTokenTypes.OP; }
}
[^] { return TokenType.BAD_CHARACTER; }