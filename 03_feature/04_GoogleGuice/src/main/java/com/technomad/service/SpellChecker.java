package com.technomad.service;

import com.google.inject.ImplementedBy;

@ImplementedBy(SpellCheckerImpl.class)
public interface SpellChecker {
    public void checkSpelling();
}
