package com.farenda.junit;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FixturesTest {

    private User user;
    private User jon = new User("Jon", "Snow");

    @BeforeClass
    public static void executedOnceBeforeAllTestsInThisClass() {
        System.out.println("Instantiating a heavy resource.");
    }

    @Before
    public void calledBeforeEachTest() {
        System.out.println("Recreating User!");
        user = new User("James", "Brown");
    }

    @After
    public void calledAfterEachTest() {
        System.out.println("Cleanup after a test!");
    }

    @AfterClass
    public static void executedOnceAfterAllTestsInThisClass() {
        System.out.println("Disposing a heavy resource.");
    }

    @Test
    public void shouldHaveJonSnow() {
        System.out.println("Checking Jon Snow.");
        assertNotNull(jon);
        assertEquals("Jon", jon.getFirstName());
        assertEquals("Snow", jon.getLastName());
    }

    @Test
    public void shouldHaveUser() {
        System.out.println("Executing shouldHaveUser test");
        assertNotNull(user);
        assertEquals("James", user.getFirstName());
        assertEquals("Brown", user.getLastName());

        // this affects only current method:
        user.setFirstName("Michael");
        user.setLastName("Jackson");
    }

    @Test
    public void shouldHaveRecreatedUser() {
        System.out.println("Executing shouldHaveRecreatedUser test");
        assertNotNull(user);
        assertEquals("James", user.getFirstName());
        assertEquals("Brown", user.getLastName());
    }
}
