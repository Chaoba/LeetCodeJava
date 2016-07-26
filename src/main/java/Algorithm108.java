import com.mushuichuan.beans.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree  QuestionEditorial Solution  My Submissions
 * Total Accepted: 83062
 * Total Submissions: 216584
 * Difficulty: Medium
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Created by Liyanshun on 2016/7/26.
 */
public class Algorithm108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getRoot(nums, 0, nums.length - 1);
    }

    TreeNode getRoot(int[] nums, int begin, int end) {
        TreeNode root;
        if (begin <= end) {
            int mid = (begin + end) / 2;
            root = new TreeNode(nums[mid]);
            root.left = getRoot(nums, begin, mid - 1);
            root.right = getRoot(nums, mid + 1, end);
            return root;
        } else {
            return null;
        }
    }
}
