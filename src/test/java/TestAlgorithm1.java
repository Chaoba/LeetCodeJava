import com.mushuichuan.Algorithm1;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm1 {
    @Test
    public void test() {
        int[] source = {2, 7, 11, 15};
        int target = 9;
        int[] solution = new Algorithm1().twoSum(source, target);
        int[] result = {0, 1};
        assertArrayEquals(solution, result);

    }
}
