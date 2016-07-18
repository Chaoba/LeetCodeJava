import com.mushuichuan.Algorithm3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm3 {
    @Test
    public void test1() {
        String source = "abcabcbb";
        int solution = new Algorithm3().lengthOfLongestSubstring(source);
        assertEquals(3,solution);
    }

    @Test
    public void test2() {
        String source = "bbbbb";
        int solution = new Algorithm3().lengthOfLongestSubstring(source);
        assertEquals(1,solution);
    }

    @Test
    public void test3() {
        String source = "pwwkew";
        int solution = new Algorithm3().lengthOfLongestSubstring(source);
        assertEquals(3,solution);
    }

    @Test
    public void test4() {
        String source = "au";
        int solution = new Algorithm3().lengthOfLongestSubstring(source);
        assertEquals(2,solution);
    }

    @Test
    public void test5() {
        String source = "aa";
        int solution = new Algorithm3().lengthOfLongestSubstring(source);
        assertEquals(1, solution);
    }

    @Test
    public void test6() {
        String source = "cdd";
        int solution = new Algorithm3().lengthOfLongestSubstring(source);
        assertEquals(2, solution);
    }

}
