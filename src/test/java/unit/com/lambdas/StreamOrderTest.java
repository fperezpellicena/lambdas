package unit.com.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StreamOrderTest {

    @Test
    public void remainOrder() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> lambdaNums = nums.stream().collect(Collectors.toList());

        assertEquals(nums, lambdaNums);
    }

    @Test
    public void orderNotGuaranteed() {
        Set<Integer> nums = new HashSet<>(Arrays.asList(4, 2, 3, 1));
        List<Integer> lambdaNums = nums.stream().collect(Collectors.toList());

        // May not pass
        //assertEquals(Arrays.asList(4, 2, 3, 1), lambdaNums);
    }

    @Test
    public void encounterOrder() {
        Set<Integer> nums = new HashSet<>(Arrays.asList(4, 2, 3, 1));
        List<Integer> lambdaNums = nums.stream()
                .sorted()   // perform natural ordering
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(1, 2, 3, 4), lambdaNums);
    }

    @Test
    public void encounterOrderPropagation() {
        Set<Integer> nums = new HashSet<>(Arrays.asList(4, 2, 3, 1));
        List<Integer> lambdaNums = nums.stream()
                .sorted()           // perform natural ordering(encounter order)
                .map(x -> x + 1)    // encounter order is preserved
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(2, 3, 4, 5), lambdaNums);
    }
}
