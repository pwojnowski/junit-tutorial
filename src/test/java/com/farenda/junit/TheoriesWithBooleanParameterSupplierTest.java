package com.farenda.junit;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.internal.BooleanSupplier;
import org.junit.runner.RunWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class TheoriesWithBooleanParameterSupplierTest {

    // We need it only at run-time:
    @Retention(RetentionPolicy.RUNTIME)
    // Mark that its values will be provided by BooleanSupplier:
    @ParametersSuppliedBy(BooleanSupplier.class)
    public @interface Agreement {
    }

    @Theory
    public void shouldHaveCorrectPetitionState(@Agreement boolean agreed) {
        System.out.println("Signing petition with agreement: " + agreed);
        Petition petition = new Petition();
        petition.sign(agreed);
        assertTrue(petition.isSigned());
        assertThat(petition.isAgreed(), equalTo(agreed));
    }
}
