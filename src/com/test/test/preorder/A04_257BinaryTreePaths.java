package com.test.test.preorder;

import com.test.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @author William
 *
 */
public class A04_257BinaryTreePaths {

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		dfs1(list, "", root);
		return list;
	}

	public static void dfs(List<String> list, String str, TreeNode root) {
		if(root == null){
			return;
		}
		str += root.val;
		if (root.left == null && root.right == null) {
			list.add(str);
			return;
		}
		str += "->";

			dfs(list, str, root.left);
			dfs(list, str, root.right);

	}
	public static void dfs1(List<String> list, String str, TreeNode root) {
		if(root == null){
			return;
		}
 		if (root.left == null && root.right == null) {
			list.add(str + root.val);
			return;
 		}

			dfs(list, str + root.val+"->", root.left);
			dfs(list, str + root.val+"->", root.right);

	}


	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;

		t2.right =  t5;

		System.out.println(binaryTreePaths(t1));
	}
}
