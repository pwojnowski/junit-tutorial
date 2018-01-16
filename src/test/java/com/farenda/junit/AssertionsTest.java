package com.farenda.junit;

import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void shouldAssertEqualElements() {
        assertEquals(3, 3); // integers
        assertEquals(3.14, 3.14, 0.0001); // compare doubles with delta
        assertEquals("Java", "Java"); // objects
        assertEquals("The descriptive message!", 3, 3); // with message
    }

    @Test
    public void shouldAssertArrayEquality() {
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertArrayEquals("Those tables!",
                new boolean[]{true}, new boolean[]{true});
    }

    @Test
    public void shouldShowInequality() {
        assertNotEquals(3, 2+2);
        assertNotEquals("Close, but no.", 3.14, 3.1415, 0.0001);
    }

    @Test
    public void shouldAssertBooleanResults() {
        assertTrue(emptyList().isEmpty());
        assertTrue("It should be empty", emptyList().isEmpty());

        assertFalse("Yoda".isEmpty());
        assertFalse("There should be only one!", "Yoda".isEmpty());
    }

    @Test
    public void shouldTestNullness() {
        assertNull(null);
        assertNull("This one have to be null", null);

        assertNotNull("Han Solo");
        assertNotNull("Should not happen!", new Object());
    }

    @Test
    public void shouldFindTheSameObject() {
        String jedi = "Luke S";
        assertSame("There's only one Jedi!", jedi, jedi);
        assertNotSame("These guys are different!", new Object(), new Object());
    }
}
