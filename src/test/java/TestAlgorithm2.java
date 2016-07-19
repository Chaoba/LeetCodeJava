import com.mushuichuan.Algorithm2;
import com.mushuichuan.beans.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm2 {
    @Test
    public void test1() {
        ListNode l1 = TestUtils.createList("[2,4,3]");
        ListNode l2 = TestUtils.createList("[5,6,4]");

        ListNode solution = new Algorithm2().addTwoNumbers(l1, l2);
        assertEquals(TestUtils.traverseList(solution), "708");
    }

    @Test
    public void test2() {
        ListNode l1 = TestUtils.createList("[2,4,3,5]");
        ListNode l2 = TestUtils.createList("[5,6,4]");

        ListNode solution = new Algorithm2().addTwoNumbers(l1, l2);
        assertEquals(TestUtils.traverseList(solution), "7085");
    }

    @Test
    public void test3() {
        ListNode l1 = TestUtils.createList("[2,4,3]");
        ListNode l2 = TestUtils.createList("[5,6,7,2]");

        ListNode solution = new Algorithm2().addTwoNumbers(l1, l2);
        assertEquals(TestUtils.traverseList(solution), "7013");
    }

    @Test
    public void test4() {
        ListNode l1 = TestUtils.createList("[1]");
        ListNode l2 = TestUtils.createList("[9,9]");

        ListNode solution = new Algorithm2().addTwoNumbers(l1, l2);
        assertEquals(TestUtils.traverseList(solution), "001");
    }

    @Test
    public void test5() {
        ListNode l1 = TestUtils.createList("[2]");
        ListNode l2 = TestUtils.createList("[8,9,9]");

        ListNode solution = new Algorithm2().addTwoNumbers(l1, l2);
        assertEquals(TestUtils.traverseList(solution), "0001");
    }

}
