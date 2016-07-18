import com.mushuichuan.ListNode;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestUtils {
    /**
     * @param input:[2,4,3]
     * @return
     */
    public static ListNode createList(String input) {
        if (input == null || input.length() < 3) {
            return null;
        }
        String temp = input.substring(1, input.length() - 1);
        String[] nodes = temp.split(",");
        ListNode root = null, p = null, q = null;
        for (String node : nodes) {
            if (root == null) {
                root = new ListNode(Integer.valueOf(node));
                p = root;
            } else {
                q = new ListNode(Integer.valueOf(node));
                p.next = q;
                p = q;
            }
        }
        return root;
    }

    public static String traverseList(ListNode root) {
        String result = "";
        while (root != null) {
            result += root.val;
            root = root.next;
        }
        return result;
    }
}
