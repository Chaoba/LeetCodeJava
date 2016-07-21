import com.mushuichuan.Algorithm6;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm6 {
    @Test
    public void test1() {
        String s1 = "PAYPALISHIRING";
        String result = new Algorithm6().convert(s1, 3);
        assertEquals("PAHNAPLSIIGYIR", result);
    }


}
