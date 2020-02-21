// This is a generated file. Not intended for manual editing.
package com.vpoverennov.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.vpoverennov.psi.impl.*;

public interface PegenTokenTypes {

  IElementType ACTION = new PegenElementType("ACTION");
  IElementType ALT = new PegenElementType("ALT");
  IElementType META_RULE = new PegenElementType("META_RULE");
  IElementType NAMED_ATOM = new PegenElementType("NAMED_ATOM");
  IElementType PAREN_ATOM = new PegenElementType("PAREN_ATOM");
  IElementType RULE = new PegenElementType("RULE");
  IElementType SQB_ATOM = new PegenElementType("SQB_ATOM");

  IElementType AMPER = new PegenTokenType("AMPER");
  IElementType AT = new PegenTokenType("AT");
  IElementType COLON = new PegenTokenType("COLON");
  IElementType CUT = new PegenTokenType("CUT");
  IElementType DOLLAR_SIGN = new PegenTokenType("DOLLAR_SIGN");
  IElementType DOT = new PegenTokenType("DOT");
  IElementType EQUAL = new PegenTokenType("EQUAL");
  IElementType LBRACE = new PegenTokenType("LBRACE");
  IElementType LINE_COMMENT = new PegenTokenType("LINE_COMMENT");
  IElementType LPAREN = new PegenTokenType("LPAREN");
  IElementType LSQB = new PegenTokenType("LSQB");
  IElementType META_NAME = new PegenTokenType("META_NAME");
  IElementType NAME = new PegenTokenType("NAME");
  IElementType NEWLINE = new PegenTokenType("NEWLINE");
  IElementType NL = new PegenTokenType("NL");
  IElementType NOT = new PegenTokenType("NOT");
  IElementType NUMBER = new PegenTokenType("NUMBER");
  IElementType OP = new PegenTokenType("OP");
  IElementType PLUS = new PegenTokenType("PLUS");
  IElementType QUESTION_MARK = new PegenTokenType("QUESTION_MARK");
  IElementType RBRACE = new PegenTokenType("RBRACE");
  IElementType RPAREN = new PegenTokenType("RPAREN");
  IElementType RSQB = new PegenTokenType("RSQB");
  IElementType RULE_NAME = new PegenTokenType("RULE_NAME");
  IElementType STAR = new PegenTokenType("STAR");
  IElementType STRING = new PegenTokenType("STRING");
  IElementType VBAR = new PegenTokenType("VBAR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACTION) {
        return new PegenActionImpl(node);
      }
      else if (type == ALT) {
        return new PegenAltImpl(node);
      }
      else if (type == META_RULE) {
        return new PegenMetaRuleImpl(node);
      }
      else if (type == NAMED_ATOM) {
        return new PegenNamedAtomImpl(node);
      }
      else if (type == PAREN_ATOM) {
        return new PegenParenAtomImpl(node);
      }
      else if (type == RULE) {
        return new PegenRuleImpl(node);
      }
      else if (type == SQB_ATOM) {
        return new PegenSqbAtomImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
