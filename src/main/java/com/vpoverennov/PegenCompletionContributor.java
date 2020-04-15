
package com.vpoverennov;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.vpoverennov.psi.PegenFile;
import com.vpoverennov.psi.PegenNamedAtom;
import com.vpoverennov.psi.PegenRule;
import com.vpoverennov.psi.PegenTokenTypes;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PegenCompletionContributor extends CompletionContributor {
    public PegenCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(PegenTokenTypes.META_NAME).withLanguage(PegenLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        for (String metaName : PegenUtil.getPredefinedMetas())
                            resultSet.addElement(LookupElementBuilder.create(metaName));
                    }
                }
        );
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(PegenTokenTypes.RULE_NAME).withLanguage(PegenLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PegenFile file = (PegenFile) parameters.getOriginalPosition().getContainingFile();
                        List<PegenNamedAtom> namedAtoms = PegenUtil.findUnresolvedRules(file);
                        for (PegenNamedAtom namedAtom : namedAtoms)
                            if (namedAtom.getName() != null && namedAtom.getName().length() > 0)
                                resultSet.addElement(LookupElementBuilder.create(namedAtom.getName()));
                    }
                }
        );
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(PegenTokenTypes.NAME).withLanguage(PegenLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PegenFile file = (PegenFile) parameters.getOriginalPosition().getContainingFile();
                        List<PegenRule> rules = PegenUtil.findRules(file);
                        for (PegenRule rule : rules)
                            if (rule.getName() != null && rule.getName().length() > 0)
                                resultSet.addElement(LookupElementBuilder.create(rule.getName()));
                    }
                }
        );
    }
}
