package unit.com.lambdas;

import org.junit.Before;
import org.junit.Test;
import unit.com.lambdas.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class StreamOperationsTest {

    @Test
    public void simpleCollectToListOperation() {
        List<String> collectedAnimals = Stream.of("cat", "dog", "bird")
                .collect(toList());
	    final List<String> expectedAnimals = asList("cat", "dog", "bird");
	    assertEquals(expectedAnimals, collectedAnimals);
    }


    @Test
    public void simpleMapOperation() {
        List<String> collectedAnimals = Stream.of("cat", "dog", "bird")
                .map(animal -> animal.toUpperCase())
                .collect(toList());
	    final List<String> expectedUppercaseAnimals = asList("CAT", "DOG", "BIRD");
	    assertEquals(expectedUppercaseAnimals, collectedAnimals);
    }

    @Test
    public void simpleFilterOperation() {
        List<String> collectedAnimals = Stream.of("cat", "dog", "bird")
                .filter(animal -> animal.startsWith("c"))
                .collect(toList());
	    final List<String> filteredAnimals = asList("cat");
	    assertEquals(filteredAnimals, collectedAnimals);
    }

    @Test
    public void simpleFlatMapOperation() {
	    final List<String> pets = asList("cat", "dog", "bird");
	    final List<String> wildAnimals = asList("horse", "duck", "crocodile");
	    List<String> filteredAnimals = Stream.of(pets, wildAnimals)
                .flatMap(animals -> animals.stream())
                .collect(toList());
	    final List<String> fauna = asList("cat", "dog", "bird", "horse", "duck", "crocodile");
	    assertEquals(fauna, filteredAnimals);
    }

    @Test
    public void simpleMaxOperation() {
	    User john = new User("John Doe", 26);
	    User paul = new User("Paul Pitts", 19);
	    User lisa = new User("Lisa Romain", 24);
        User agedUser = Stream.of(john, paul, lisa)
                .max(Comparator.comparing(user -> user.getAge()))
                .get();
        assertEquals(john, agedUser);
    }

    @Test
    public void simpleMinOperation() {
	    User john = new User("John Doe", 26);
	    User paul = new User("Paul Pitts", 19);
	    User lisa = new User("Lisa Romain", 24);
	    User youngerUser = Stream.of(john, paul, lisa)
                .min(Comparator.comparing(user -> user.getAge()))
                .get();
        assertEquals(paul, youngerUser);
    }

    @Test
    public void simpleReduceOperation() {
	    User john = new User("John Doe", 26);
	    User paul = new User("Paul Pitts", 19);
	    User lisa = new User("Lisa Romain", 24);
        int sum = Stream.of(john, paul, lisa)
			    .map(user -> user.getAge())
                .reduce(0, (ageOfUserA, ageOfUserB) -> (ageOfUserA + ageOfUserB));
        assertEquals(69, sum);
    }

}
