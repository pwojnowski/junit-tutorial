package com.farenda.junit;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.experimental.theories.PotentialAssignment.forValue;

public class FibonacciParameterSupplier extends ParameterSupplier {

    private static final String VALIDATION_ERROR_MESSAGE
            = "\"n\" must be non negative number! Was: %d";

    @Retention(RetentionPolicy.RUNTIME)
    @ParametersSuppliedBy(FibonacciParameterSupplier.class)
    public @interface FibonacciNumbers {
        /**
         * Number of Fibonacci numbers to return.
         */
        int n();
    }

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
        FibonacciNumbers ann = sig.getAnnotation(FibonacciNumbers.class);
        validatePrecondition(ann.n());
        return singletonList(forValue("n", calculateFibos(ann.n())));
    }

    private void validatePrecondition(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format(VALIDATION_ERROR_MESSAGE, n));
        }
    }

    private int[] calculateFibos(int n) {
        int[] numbers = new int[n];
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            numbers[i] = b;
            int tmp = b;
            b += a;
            a = tmp;
        }
        return numbers;
    }
}
