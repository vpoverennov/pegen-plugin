package com.vpoverennov;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import com.vpoverennov.psi.PegenFile;
import com.vpoverennov.psi.PegenNamedAtom;
import com.vpoverennov.psi.PegenRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PegenReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String key;

    public PegenReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return ((PegenNamedAtom) myElement).setName(newElementName);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        PegenFile file = (PegenFile) myElement.getContainingFile();
        final List<PegenRule> rules = PegenUtil.findRules(file, key);
        List<ResolveResult> results = new ArrayList<>();
        for (PegenRule rule : rules)
            results.add(new PsiElementResolveResult(rule));
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }
}
