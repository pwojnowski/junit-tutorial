package com.farenda.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertTrue;

@RunWith(Suite.class)
@Suite.SuiteClasses({RunnersExampleTest.class})
public class RunnersExampleTest {

    @Test
    public void shouldPass() {
        assertTrue(true);
    }
}
