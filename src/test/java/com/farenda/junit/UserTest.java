package com.farenda.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userShouldHaveGivenName() {
        User user = new User("Michael", "Jordan");

        assertEquals("Michael", user.getFirstName());
        assertEquals("Jordan", user.getLastName());
    }
}
