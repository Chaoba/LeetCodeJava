package com.mushuichuan.test;

import com.mushuichuan.Algorithm236;
import com.mushuichuan.beans.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/24.
 */
public class TestAlgorithm236 {
    @Test
    public void test1() {
        String in = "[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]";
        TreeNode root = TestUtils.createTree(in);
        TreeNode result = new Algorithm236().lowestCommonAncestor(root, root.right.left, root.right.right.left.left);
        assertEquals(root.right, result);
    }

    @Test
    public void test2() {
        String in = "[1,2,3,4,null,5,6]";
        TreeNode root = TestUtils.createTree(in);
        TreeNode result = new Algorithm236().lowestCommonAncestor(root, root, root.left);
        assertEquals(root, result);
    }

    @Test
    public void test3() {
        String in = "[1,2,3,4,null,5,6]";
        TreeNode root = TestUtils.createTree(in);
        TreeNode result = new Algorithm236().lowestCommonAncestor(root, root.left.left, root.right.left);
        assertEquals(root, result);
    }

    @Test
    public void test4() {
        String in = "[1,2,3,4,null,5,6]";
        TreeNode root = TestUtils.createTree(in);
        TreeNode result = new Algorithm236().lowestCommonAncestor(root, root.right.left, root.right.right);
        assertEquals(root.right, result);
    }

}
