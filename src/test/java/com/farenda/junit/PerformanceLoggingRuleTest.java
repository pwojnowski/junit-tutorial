package com.farenda.junit;

import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.Random;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.Assert.assertEquals;

public class PerformanceLoggingRuleTest {

    @Rule
    public ExternalResource performanceLogger = new ExternalResource() {

        private long testStart;
        private String testName;

        @Override
        protected void before() throws Throwable {
            // Do some pre-test action here - e.g. open connection.
            testStart = System.currentTimeMillis();
        }

        // Don't override if you don't want to modify Statement.
        @Override
        public Statement apply(Statement base, Description description) {
            // You can do some action here.
            testName = description.getMethodName();

            // Return new Statement() {...} if you want to evaluate differently
            return super.apply(base, description);
        }

        @Override
        protected void after() {
            // Do some post-test action - e.g. close connection.
            System.out.printf("%s executed in: %dms%n",
                    testName, System.currentTimeMillis() - testStart);
        }
    };

    @Test
    public void cryptoCruncher() throws InterruptedException {
        MILLISECONDS.sleep(new Random().nextInt(1000));
        assertEquals("Java", "Java");
    }

    @Test
    public void cpuStealer() throws InterruptedException {
        MILLISECONDS.sleep(new Random().nextInt(1000));
        assertEquals("JUnit".length(), 5);
    }
}
