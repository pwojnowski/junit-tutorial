package com.farenda.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdditionTest.class,
        SubstractionTest.class
})
public class CalculatorTestSuite {

    // Content may be empty.
    // Only annotations matter.
}
