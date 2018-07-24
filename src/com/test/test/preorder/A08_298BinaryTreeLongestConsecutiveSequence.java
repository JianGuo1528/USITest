package com.test.test.preorder;

import com.test.pojo.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * 
 * @author William
 *
 */
public class A08_298BinaryTreeLongestConsecutiveSequence {
	static int max = 1;

 	public static int longestConsecutive(TreeNode root) {
		dfs(root, root.left, 1);
		dfs(root, root.right, 1);
 		return max;
	}

	public static void dfs(TreeNode parent, TreeNode child, int len) {
		if (child == null) {
			max = Math.max(max, len);
			return;
		}
		if (child.val - 1 == parent.val) {
			len ++;
		}else {
			max = Math.max(max, len);
			len = 1;
		}
		dfs(child, child.left, len);
		dfs(child, child.right, len);
	}

 	public static int longestConsecutive1(TreeNode root) {
 		if(root == null){
			return 0;
		}
		dfs1(root,1);
  		return max;
	}

	public static void dfs1(TreeNode root,  int c) {
 		if(root.left != null){
			if(root.val + 1 == root.left.val){
				dfs1(root.left,c+1);
				max = Math.max(max,c+1);
			}else{
				dfs1(root.left, 1);
			}
		}
 		if(root.right != null){
			if(root.val + 1 == root.right.val){
				dfs1(root.right,c+1);
				max = Math.max(max,c+1);
			}else{
				dfs1(root.right, 1);
			}
		}


	}

 	public static void main(String[] args) {
		/*TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left =  t2;

		t2.left =  t3;
		t2.right =  t4;

		t4.right = t5;*/

		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(1);

		t1.right = t2;

		t2.left =  t3;

		t3.left =  t4;

		System.out.println(longestConsecutive1(t1));
	}
}
