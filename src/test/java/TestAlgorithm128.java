import com.mushuichuan.Algorithm128;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm128 {
    @Test
    public void test1() {
        int[] source = {100, 4, 200, 1, 3, 2};
        int num = new Algorithm128().longestConsecutive(source);
        assertEquals(4, num);

    }

}
