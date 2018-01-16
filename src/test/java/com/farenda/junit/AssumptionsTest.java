package com.farenda.junit;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.*;

public class AssumptionsTest {

    @Test
    public void shouldRunOnlyOnLinux() {
        assumeThat(System.getProperty("os.name"), is("Linux"));
        assertThat(Paths.get("/tmp").toString(), equalTo("/tmp"));
    }

    @Test
    public void shouldRunOnlyWhenOneIsOne() {
        assumeTrue("Expected true!", 1 == 1);
        assertThat(1 + 1, is(2));
    }

    @Test
    public void shouldRunOnlyWhenFalse() {
        assumeFalse("Expected false!", 1 == 2);
        assertThat(Math.pow(2, 3), is(8.0));
    }

    @Test
    public void shouldRunOnlyWhenCanOpenFile() {
        List<String> data = null;
        try {
            data = Files.readAllLines(Paths.get("/proc/meminfo"));
        } catch (IOException e) {
            assumeNoException(e);
        }
        assertThat(data.isEmpty(), is(false));
    }
}
