import com.mushuichuan.beans.ListNode;
import com.mushuichuan.beans.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
                root = new ListNode(Integer.valueOf(node.trim()));
                p = root;
            } else {
                q = new ListNode(Integer.valueOf(node.trim()));
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

    public static int[] createIntArray(String input) {
        if (input == null || input.length() < 3) {
            return null;
        }
        String temp = input.substring(1, input.length() - 1);
        String[] nodes = temp.split(",");
        int[] result = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            result[i] = Integer.valueOf(nodes[i].trim());
        }
        return result;
    }

    public static TreeNode createTree(String input) {
        if (input == null || input.length() < 3) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        String temp = input.substring(1, input.length() - 1);
        String[] nodes = temp.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root);
        for (int i = 1; i < nodes.length; i = i + 2) {
            TreeNode tempNode = queue.poll();
            if (tempNode != null) {
                if (i < nodes.length && !"null".equals(nodes[i])) {
                    tempNode.left = new TreeNode(Integer.valueOf(nodes[i]));
                    queue.add(tempNode.left);
                }
                if (i + 1 < nodes.length && !"null".equals(nodes[i + 1])) {
                    tempNode.right = new TreeNode(Integer.valueOf(nodes[i + 1]));
                    queue.add(tempNode.right);
                }
            }
        }
        return root;
    }

    public static String printTree(TreeNode head) {
        StringBuilder builder = new StringBuilder();
        do {
            builder.append(head.val);
            if (head.left != null) {
                builder.append(head.left.val);
            } else {
                if (head.right != null) {
                    builder.append("null");
                }
            }
            if (head.left != null) {
                builder.append(head.right.val);
            }
            head = head.right;
        } while (head != null);
        return builder.toString();
    }

    public static char[][] createCharArray(String[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        char[][] result = new char[input.length][input[0].length()];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i].toCharArray();
        }
        return result;
    }
}
