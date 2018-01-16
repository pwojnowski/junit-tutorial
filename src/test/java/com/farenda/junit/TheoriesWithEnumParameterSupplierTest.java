package com.farenda.junit;

import org.junit.experimental.theories.*;
import org.junit.experimental.theories.internal.EnumSupplier;
import org.junit.runner.RunWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class TheoriesWithEnumParameterSupplierTest {

    // Sample enum that we want to test:
    enum Language {
        JAVA, GROOVY, CLOJURE, SCALA;

        public int length() {
            return name().length();
        }
    }

    public static class LanguageSupplier extends EnumSupplier {
        public LanguageSupplier() {
            super(Language.class);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @ParametersSuppliedBy(LanguageSupplier.class)
    public @interface Lang {
    }

    @Theory
    public void shouldNotHaveShortLanguagesInEnum(@Lang Language l) {
        System.out.println("Checking language: " + l);
        assertEquals(l.length(), l.toString().length());
    }
}
