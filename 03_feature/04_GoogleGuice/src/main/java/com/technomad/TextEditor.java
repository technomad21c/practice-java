package com.technomad;

import com.google.inject.Inject;
import com.technomad.service.SpellChecker;

public class TextEditor {
    @Inject
    private SpellChecker spellChecker;

//    @Inject
//    public void setSpellChecker(SpellChecker spellChecker) {
//        this.spellChecker = spellChecker;
//    }
    public TextEditor() { }

    public void makeSpellCheck() {
        spellChecker.checkSpelling();
    }
}
