package unit.com.lambdas;

import org.junit.Test;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static org.junit.Assert.assertEquals;

public class CollectorTest {

    @Test
    public void collectorToMap() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        Map<Integer, Integer> map = nums.stream()
                .collect(Collectors.toMap(x -> x, x -> x * x));

        Map<Integer, Integer> expected = new HashMap(){
            {
                put(1, 1);
                put(2, 4);
                put(3, 9);
                put(4, 16);
            }
        };
        assertEquals(expected, map);
    }

    @Test
    public void collectorToSet() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        Set<Integer> set = nums.stream()
                .collect(Collectors.toSet());

        Set<Integer> expected = new HashSet(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        assertEquals(expected, set);
    }

    @Test
    public void collectorToCustomCollection() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        Set<Integer> set = nums.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        Set<Integer> expected = new TreeSet(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        assertEquals(expected, set);
    }

    @Test
    public void collectMaxBy() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        Optional<Integer> max = nums.stream()
                .collect(maxBy(comparing(x -> x)));

        assertEquals(Optional.of(4), max);
    }

    @Test
    public void collectMinBy() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        Optional<Integer> max = nums.stream()
                .collect(minBy(comparing(x -> x)));

        assertEquals(Optional.of(1), max);
    }

    @Test
    public void collectAveraging() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        ToIntFunction<Integer> mapper = x -> nums.size();

        double collect = nums.stream().collect(averagingInt(mapper));
        assertEquals(4.0, collect, 0);
    }
}
