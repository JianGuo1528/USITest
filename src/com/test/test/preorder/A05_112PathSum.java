package com.test.test.preorder;

import com.test.pojo.TreeNode;

/**
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @author William
 *
 */
public class A05_112PathSum {

	public static boolean hasPathSum(TreeNode root, int sum) {
		return dfs(root, 0, sum);
	}

	public static boolean dfs(TreeNode root, int value, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return (value + root.val) == sum;
		}
		value += root.val;
		return dfs(root.left, value, sum) || dfs(root.right, value, sum);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(1);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;

		t3.left =  t5;
		t3.right = t6;

		t4.left = t7;
		t4.right = t8;

		t6.right = t9;

		System.out.println(hasPathSum(t1,22));
	}
}
