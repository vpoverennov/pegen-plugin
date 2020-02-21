package com.vpoverennov;

import com.intellij.psi.util.PsiTreeUtil;
import com.vpoverennov.psi.PegenAlt;
import com.vpoverennov.psi.PegenNamedAtom;
import com.vpoverennov.psi.PegenRule;
import com.vpoverennov.psi.PegenFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PegenUtil {
    private static final String[] PREDEFINED_METAS = {"header", "subheader", "bytecode", "modulename", "trailer"};

    public static String[] getPredefinedMetas() {
        return PREDEFINED_METAS;
    }

    public static List<PegenRule> findRules(PegenFile file, String key) {
        List<PegenRule> result = new ArrayList<>();
        PegenRule[] rules = PsiTreeUtil.getChildrenOfType(file, PegenRule.class);
        if (rules != null) {
            for (PegenRule rule : rules) {
                if (key.equals(rule.getName())) {
                    result.add(rule);
                }
            }
        }
        return result;
    }

    public static List<PegenRule> findRules(PegenFile file) {
        List<PegenRule> result = new ArrayList<>();
        PegenRule[] rules = PsiTreeUtil.getChildrenOfType(file, PegenRule.class);
        if (rules != null) {
            Collections.addAll(result, rules);
        }
        return result;
    }

    public static List<PegenNamedAtom> findUnresolvedRules(PegenFile file) {
        List<PegenRule> rules = findRules(file);
        List<String> ruleNames = rules.stream().map(PegenRule::getName).collect(Collectors.toList());
        List<PegenNamedAtom> result = new ArrayList<>();
        for (PegenRule rule : rules) {
            PegenNamedAtom[] references = getReferences(rule);
            for (PegenNamedAtom reference : references)
                if (!ruleNames.contains(reference.getName()))
                    result.add(reference);
                else
                    System.out.println(reference.getName());
        }
        return result;
    }

    public static PegenNamedAtom[] getReferences(PegenRule rule) {
        List<PegenNamedAtom> result = new ArrayList<>();
        PegenAlt[] alts = PsiTreeUtil.getChildrenOfType(rule, PegenAlt.class);
        if (alts != null) {
            for (PegenAlt alt : alts) {
                PegenNamedAtom[] namedAtoms = PsiTreeUtil.getChildrenOfType(alt, PegenNamedAtom.class);
                if (namedAtoms != null) {
                    Collections.addAll(result, namedAtoms);
                }
            }
        }
        return result.toArray(new PegenNamedAtom[result.size()]);
    }
}