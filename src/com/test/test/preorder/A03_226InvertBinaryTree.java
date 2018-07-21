package com.test.test.preorder;

import com.test.pojo.TreeNode;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author William
 *
 */
public class A03_226InvertBinaryTree {

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		dfs(root.left, root.right, root);
//		TreeNode temp = root.left;
//		root.left = root.right;
//		root.right = temp;
		return root;
	}

	public static void dfs(TreeNode p, TreeNode q, TreeNode root) {
		if (p == null || q == null) {
			return;
		}

		root.right = p;
		root.left = q;

		dfs(p.left, p.right, p);
		dfs(q.left, q.right, q);
	}

//	public static TreeNode invertTree(TreeNode root) {
//		if(root == null){
//			return root;
//		}
//		TreeNode l = invertTree(root.left);
//		TreeNode r = invertTree(root.right);
//		root.left = r;
//		root.right = l;
//		return root;
//	}

 	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(9);

		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		t3.left = t6;
		t3.right = t7;

		System.out.println(invertTree(t1));
	}
}
