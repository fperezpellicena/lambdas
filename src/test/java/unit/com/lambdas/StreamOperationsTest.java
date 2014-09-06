package unit.com.lambdas;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class StreamOperationsTest {

    @Test
    public void simpleCollectToListOperation() {
        List<String> animals = Stream.of("cat", "dog", "bird")
                .collect(toList());
        assertEquals(asList("cat", "dog", "bird"), animals);
    }


    @Test
    public void simpleMapOperation() {
        List<String> upperCaseAnimals = Stream.of("cat", "dog", "bird")
                .map(animal -> animal.toUpperCase())
                .collect(toList());
        assertEquals(asList("CAT", "DOG", "BIRD"), upperCaseAnimals);
    }

    @Test
    public void simpleFilterOperation() {
        List<String> filteredAnimals = Stream.of("cat", "dog", "bird")
                .filter(animal -> animal.startsWith("c"))
                .collect(toList());
        assertEquals(asList("cat"), filteredAnimals);
    }

    @Test
    public void simpleFlatMapOperation() {
        List<String> filteredAnimals = Stream.of(asList("cat", "dog", "bird"), asList("horse", "duck", "crocodile"))
                .flatMap(animals -> animals.stream())
                .collect(toList());
        assertEquals(asList("cat", "dog", "bird", "horse", "duck", "crocodile"), filteredAnimals);
    }

    @Test
    public void simpleMaxOperation() {
        String lastAnimal = Stream.of("cat", "dog", "bird")
                .max(Comparator.comparing(animal -> animal.charAt(0)))
                .get();
        assertEquals("dog", lastAnimal);
    }

    @Test
    public void simpleMinOperation() {
        String firstAnimal = Stream.of("cat", "dog", "bird")
                .min(Comparator.comparing(animal -> animal.charAt(0)))
                .get();
        assertEquals("bird", firstAnimal);
    }

    @Test
    public void simpleReduceOperation() {
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (a,b) -> a + b);
        assertEquals(15, sum);
    }

}
