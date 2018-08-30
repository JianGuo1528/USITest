package com.test.test.basic;


import com.test.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author William
 *
 */
public class A04_102BinaryTreeLevelOrderTraversal {
	private static List<Integer> list = new ArrayList<>();

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		dfs(root, list, 0);
		return list;
	}

	public static void dfs(TreeNode root, List<List<Integer>> list, int level) {
		if (root == null) {
			return;
		}

	/*	if (list.size() <= level) {
			List<Integer> integers = new ArrayList<>();
			integers.add(root.val);
			list.add(integers);
		}else {
			list.get(level).add(root.val);
		}*/

		if (list.size() == level) {
			list.add(new ArrayList<>());
		}
		list.get(level).add(root.val);
		dfs(root.left, list, level + 1);
		dfs(root.right, list, level + 1);
	}

	private static void preOrder(TreeNode root) {
		list.add(root.val);
		if (root.left != null) {
			preOrder(root.left);
		}
		if (root.right != null) {
			preOrder(root.right);
		}
	}

	private static void inOrder(TreeNode root) {
		if (root.left != null) {
			inOrder(root.left);
		}
		list.add(root.val);
		if (root.right != null) {
			inOrder(root.right);
		}
	}

	private static void postOrder(TreeNode root) {
		if (root.left != null) {
			postOrder(root.left);
		}
		if (root.right != null) {
			postOrder(root.right);
		}
		list.add(root.val);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;

		t3.left = t4;
		t3.right = t5;

//		System.out.println(levelOrder(t1));

		postOrder(t1);
		System.out.println(list);
	}
}
