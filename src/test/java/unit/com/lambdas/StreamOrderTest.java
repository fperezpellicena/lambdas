package unit.com.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class StreamOrderTest {

    @Test
    public void remainOrder() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> lambdaNums = nums.stream().collect(toList());

        assertEquals(nums, lambdaNums);
    }

    @Test
    public void orderNotGuaranteed() {
        Set<Integer> nums = new HashSet<>(Arrays.asList(4, 2, 3, 1));
        List<Integer> lambdaNums = nums.stream().collect(toList());
        
        // May not pass
        //assertEquals(Arrays.asList(4, 2, 3, 1), lambdaNums);
    }

    @Test
    public void encounterOrder() {
        Set<Integer> originalIntegerSet = new HashSet<>(Arrays.asList(4, 2, 3, 1));
        List<Integer> sortedIntegerSet = originalIntegerSet.stream()
                .sorted()   // perform natural ordering
                .collect(toList());

	    final List<Integer> naturalSortedSet = Arrays.asList(1, 2, 3, 4);
	    assertEquals(naturalSortedSet, sortedIntegerSet);
    }

    @Test
    public void encounterOrderPropagation() {
        Set<Integer> originalIntegerSet = new HashSet<>(Arrays.asList(4, 2, 3, 1));
        List<Integer> sortedIntegerSet = originalIntegerSet.stream()
                .sorted()           // perform natural ordering(encounter order)
                .map(x -> x + 1)    // encounter order is preserved
                .collect(toList());

	    final List<Integer> naturalSortedSet = Arrays.asList(2, 3, 4, 5);
	    assertEquals(naturalSortedSet, sortedIntegerSet);
    }
}
