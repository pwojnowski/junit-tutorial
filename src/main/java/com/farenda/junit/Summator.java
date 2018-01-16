package com.farenda.junit;

import java.util.Arrays;

public class Summator {

    public int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
