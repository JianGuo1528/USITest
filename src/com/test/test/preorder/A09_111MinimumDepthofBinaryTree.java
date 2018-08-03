package com.test.test.preorder;


import com.test.pojo.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 * 
 * @author William
 *
 */
public class A09_111MinimumDepthofBinaryTree {
	private static int min = Integer.MAX_VALUE;

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		dfs(root, 0);
		return min;
	}

//	private static int dfs(TreeNode root, int len) {
//		if (root.left == null && root.right == null) return 1;
//
//
//		else if (root.left == null) {
//			return  dfs(root.right, len)+1;
//		} else if (root.right == null) {
//			return  dfs(root.left , len)+1;
//		}else {
//			return Math.min(dfs(root.left, len),dfs(root.right, len)) +1;
//		}
//	}

	private static void dfs(TreeNode root, int len) {
//		if (root.left == null && root.right == null) {
//			min = Math.min(len + 1, min);
//			return;
//		}
//
//		if (root.left == null) {
//			dfs(root.right, len + 1);
//		} else if (root.right == null) {
//			dfs(root.left, len + 1);
//		} else {
//			dfs(root.left, len + 1);
//			dfs(root.right, len + 1);
//		}



	}

	public int minDepth2(TreeNode root) {
		if(root == null)
			return 0;

		int left = minDepth(root.left);
		int right = minDepth(root.right);

		if(left == 0 || right == 0)
			return left + right + 1;
		else
			return Math.min(left,right) + 1;


	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
//		TreeNode right = new TreeNode(20);
		root.left = left;
//		root.right = right;
//
//		right.left = new TreeNode(15);
//		right.right = new TreeNode(7);

		System.out.println(minDepth(root));
	}
}
