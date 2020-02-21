// This is a generated file. Not intended for manual editing.
package com.vpoverennov.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.vpoverennov.psi.PegenTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PegenParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return pegenFile(b, l + 1);
  }

  /* ********************************************************** */
  // LBRACE target_atom_+ RBRACE
  public static boolean action(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ACTION, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, action_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // target_atom_+
  private static boolean action_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = target_atom_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!target_atom_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "action_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // item_+ DOLLAR_SIGN? action?
  public static boolean alt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALT, "<alt>");
    r = alt_0(b, l + 1);
    r = r && alt_1(b, l + 1);
    r = r && alt_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item_+
  private static boolean alt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alt_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DOLLAR_SIGN?
  private static boolean alt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alt_1")) return false;
    consumeToken(b, DOLLAR_SIGN);
    return true;
  }

  // action?
  private static boolean alt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alt_2")) return false;
    action(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // alt vbar_alt_*
  static boolean alts_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alts_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = alt(b, l + 1);
    r = r && alts__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // vbar_alt_*
  private static boolean alts__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alts__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vbar_alt_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alts__1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // named_atom | STRING | paren_atom
  static boolean atom_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_")) return false;
    boolean r;
    r = named_atom(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = paren_atom(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LBRACE target_atom_+ RBRACE
  static boolean brace_atom_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_atom_")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, brace_atom__1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // target_atom_+
  private static boolean brace_atom__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_atom__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = target_atom_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!target_atom_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_atom__1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // meta_rule* (rule NEWLINE)* rule?
  static boolean grammar_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grammar_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = grammar__0(b, l + 1);
    r = r && grammar__1(b, l + 1);
    r = r && grammar__2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // meta_rule*
  private static boolean grammar__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grammar__0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!meta_rule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grammar__0", c)) break;
    }
    return true;
  }

  // (rule NEWLINE)*
  private static boolean grammar__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grammar__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!grammar__1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grammar__1", c)) break;
    }
    return true;
  }

  // rule NEWLINE
  private static boolean grammar__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grammar__1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rule(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // rule?
  private static boolean grammar__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grammar__2")) return false;
    rule(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // named_item_ | simple_item_ | lookahead_
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = named_item_(b, l + 1);
    if (!r) r = simple_item_(b, l + 1);
    if (!r) r = lookahead_(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // AMPER atom_ | NOT atom_ | CUT atom_
  static boolean lookahead_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lookahead_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lookahead__0(b, l + 1);
    if (!r) r = lookahead__1(b, l + 1);
    if (!r) r = lookahead__2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // AMPER atom_
  private static boolean lookahead__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lookahead__0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AMPER);
    r = r && atom_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT atom_
  private static boolean lookahead__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lookahead__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && atom_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CUT atom_
  private static boolean lookahead__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lookahead__2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CUT);
    r = r && atom_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NAME | STRING)? NEWLINE
  static boolean meta_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_body")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_body_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (NAME | STRING)?
  private static boolean meta_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_body_0")) return false;
    meta_body_0_0(b, l + 1);
    return true;
  }

  // NAME | STRING
  private static boolean meta_body_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_body_0_0")) return false;
    boolean r;
    r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // AT META_NAME meta_body
  public static boolean meta_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_rule")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, META_RULE, null);
    r = consumeTokens(b, 1, AT, META_NAME);
    p = r; // pin = 1
    r = r && meta_body(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // VBAR alts_ (NEWLINE more_alts_)*
  static boolean more_alts_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "more_alts_")) return false;
    if (!nextTokenIs(b, VBAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, VBAR);
    p = r; // pin = 1
    r = r && report_error_(b, alts_(b, l + 1));
    r = p && more_alts__2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (NEWLINE more_alts_)*
  private static boolean more_alts__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "more_alts__2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!more_alts__2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "more_alts__2", c)) break;
    }
    return true;
  }

  // NEWLINE more_alts_
  private static boolean more_alts__2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "more_alts__2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    r = r && more_alts_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean named_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_atom")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, NAMED_ATOM, r);
    return r;
  }

  /* ********************************************************** */
  // NAME EQUAL simple_item_
  static boolean named_item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_item_")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 2, NAME, EQUAL);
    p = r; // pin = 2
    r = r && simple_item_(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // OP | AT | COLON | LBRACE | RBRACE | VBAR | AMPER | LPAREN | RPAREN | STAR | PLUS | DOT | EQUAL | LSQB | RSQB | CUT | NOT | QUESTION_MARK
  static boolean op_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_")) return false;
    boolean r;
    r = consumeToken(b, OP);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, VBAR);
    if (!r) r = consumeToken(b, AMPER);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, LSQB);
    if (!r) r = consumeToken(b, RSQB);
    if (!r) r = consumeToken(b, CUT);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, QUESTION_MARK);
    return r;
  }

  /* ********************************************************** */
  // LPAREN NEWLINE? alts_ RPAREN
  public static boolean paren_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_atom")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PAREN_ATOM, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, paren_atom_1(b, l + 1));
    r = p && report_error_(b, alts_(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // NEWLINE?
  private static boolean paren_atom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_atom_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // grammar_
  static boolean pegenFile(PsiBuilder b, int l) {
    return grammar_(b, l + 1);
  }

  /* ********************************************************** */
  // RULE_NAME rule_return_type? COLON rule_body_
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    if (!nextTokenIs(b, RULE_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE, null);
    r = consumeToken(b, RULE_NAME);
    p = r; // pin = 1
    r = r && report_error_(b, rule_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && rule_body_(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // rule_return_type?
  private static boolean rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_1")) return false;
    rule_return_type(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // alts_ NEWLINE more_alts_ | NEWLINE more_alts_ | alts_
  static boolean rule_body_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rule_body__0(b, l + 1);
    if (!r) r = rule_body__1(b, l + 1);
    if (!r) r = alts_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // alts_ NEWLINE more_alts_
  private static boolean rule_body__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body__0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = alts_(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    r = r && more_alts_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE more_alts_
  private static boolean rule_body__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    r = r && more_alts_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LSQB NAME STAR? RSQB
  static boolean rule_return_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_return_type")) return false;
    if (!nextTokenIs(b, LSQB)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, LSQB, NAME);
    p = r; // pin = 1
    r = r && report_error_(b, rule_return_type_2(b, l + 1));
    r = p && consumeToken(b, RSQB) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // STAR?
  private static boolean rule_return_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_return_type_2")) return false;
    consumeToken(b, STAR);
    return true;
  }

  /* ********************************************************** */
  // sqb_atom
  //     | atom_ QUESTION_MARK
  //     | atom_ STAR
  //     | atom_ PLUS
  //     | atom_ DOT atom_ PLUS
  //     | atom_
  static boolean simple_item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqb_atom(b, l + 1);
    if (!r) r = simple_item__1(b, l + 1);
    if (!r) r = simple_item__2(b, l + 1);
    if (!r) r = simple_item__3(b, l + 1);
    if (!r) r = simple_item__4(b, l + 1);
    if (!r) r = atom_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // atom_ QUESTION_MARK
  private static boolean simple_item__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_item__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_(b, l + 1);
    r = r && consumeToken(b, QUESTION_MARK);
    exit_section_(b, m, null, r);
    return r;
  }

  // atom_ STAR
  private static boolean simple_item__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_item__2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_(b, l + 1);
    r = r && consumeToken(b, STAR);
    exit_section_(b, m, null, r);
    return r;
  }

  // atom_ PLUS
  private static boolean simple_item__3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_item__3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_(b, l + 1);
    r = r && consumeToken(b, PLUS);
    exit_section_(b, m, null, r);
    return r;
  }

  // atom_ DOT atom_ PLUS
  private static boolean simple_item__4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_item__4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && atom_(b, l + 1);
    r = r && consumeToken(b, PLUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LSQB NEWLINE? alts_ RSQB
  public static boolean sqb_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqb_atom")) return false;
    if (!nextTokenIs(b, LSQB)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SQB_ATOM, null);
    r = consumeToken(b, LSQB);
    p = r; // pin = 1
    r = r && report_error_(b, sqb_atom_1(b, l + 1));
    r = p && report_error_(b, alts_(b, l + 1)) && r;
    r = p && consumeToken(b, RSQB) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // NEWLINE?
  private static boolean sqb_atom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqb_atom_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // brace_atom_
  //     | NAME
  //     | NUMBER
  //     | STRING
  //     | QUESTION_MARK
  //     | COLON
  //     | !RBRACE op_
  static boolean target_atom_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_atom_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_atom_(b, l + 1);
    if (!r) r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, QUESTION_MARK);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = target_atom__6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !RBRACE op_
  private static boolean target_atom__6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_atom__6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = target_atom__6_0(b, l + 1);
    r = r && op_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !RBRACE
  private static boolean target_atom__6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_atom__6_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VBAR alt
  static boolean vbar_alt_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vbar_alt_")) return false;
    if (!nextTokenIs(b, VBAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, VBAR);
    p = r; // pin = 1
    r = r && alt(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
