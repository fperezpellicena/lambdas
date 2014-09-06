package unit.com.lambdas;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    @Test
    public void staticFactoryMethods() {
        Optional<String> emptyString = Optional.empty();
        Optional<String> nullString = Optional.ofNullable(null);
        Optional<String> simpleString = Optional.of("This is a string");

        assertFalse(emptyString.isPresent());
        assertFalse(nullString.isPresent());
        assertTrue(simpleString.isPresent());
        assertEquals("This is a string", simpleString.get());
    }

    @Test
    public void orElseMethods() {
        Optional<String> emptyString = Optional.empty();

        assertEquals("Yes!", emptyString.orElse("Yes!"));
        assertEquals("Yes lambda!", emptyString.orElseGet(() -> "Yes lambda!"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void orElseThrowMethod() {
        Optional<String> emptyString = Optional.empty();
        emptyString.orElseThrow(IllegalArgumentException::new);
    }
}
