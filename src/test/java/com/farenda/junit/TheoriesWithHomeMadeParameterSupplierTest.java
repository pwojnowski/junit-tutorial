package com.farenda.junit;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.farenda.junit.FibonacciParameterSupplier.FibonacciNumbers;

@RunWith(Theories.class)
public class TheoriesWithHomeMadeParameterSupplierTest {

    private Summator summator = new Summator();

    @Theory
    public void shouldSumNumbers(@FibonacciNumbers(n = 10) int[] numbers) {
        System.out.println("Calculating sum of numbers: " + Arrays.toString(numbers));
        assertThat(summator.sum(numbers), is(143));
    }

}
