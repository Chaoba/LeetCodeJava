import com.mushuichuan.Algorithm283;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm283 {
    @Test
    public void test1() {
        int[] s = {0, 1, 0, 3, 12};
        int[] expect = {1, 3, 12, 0, 0};
        new Algorithm283().moveZeroes(s);
        assertArrayEquals(expect, s);
    }

    @Test
    public void test2() {
        int[] s = {1, 1, 0, 3, 12};
        int[] expect = {1, 1, 3, 12, 0};
        new Algorithm283().moveZeroes(s);
        assertArrayEquals(expect, s);
    }

    @Test
    public void test3() {
        int[] s = {1, 1, 3, 12};
        int[] expect = {1, 1, 3, 12};
        new Algorithm283().moveZeroes(s);
        assertArrayEquals(expect, s);
    }
}
