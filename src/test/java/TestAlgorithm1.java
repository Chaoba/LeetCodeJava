import com.mushuichuan.Algorithm1;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm1 {
    @Test
    public void test1() {
        int[] source = {2, 7, 11, 15};
        int target = 9;
        int[] solution = new Algorithm1().twoSum(source, target);
        int[] result = {0, 1};
        assertArrayEquals(result, solution);

    }

    @Test
    public void test2() {
        int[] source = {2, -7, 11, -15};
        int target = -13;
        int[] solution = new Algorithm1().twoSum(source, target);
        int[] result = {0, 3};
        assertArrayEquals(result, solution);

    }

    @Test
    public void test3() {
        int[] source = {2, 7, 11, 15, 23, 45, 78, 99, 101, 802, 904, 978};
        int target = 1882;
        int[] solution = new Algorithm1().twoSum(source, target);
        int[] result = {10, 11};
        assertArrayEquals(result, solution);

    }
}
