package trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeTraversal {

	/*
	 * Given a binary tree design an algorithm  which creates a linked list of all the nodes
	 * at each depth (if you have a tree with depth D, you'll have D linked lists)
	 */
	public static <T> ArrayList<LinkedList<BinaryTree<T>>> createLevelLinkedList(BinaryTree<T> root) {
		ArrayList<LinkedList<BinaryTree<T>>> lists = new ArrayList<LinkedList<BinaryTree<T>>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	public static <T> void createLevelLinkedList(BinaryTree<T> root, ArrayList<LinkedList<BinaryTree<T>>> lists, 
		int level) {
		if (root == null) return; // base case
		LinkedList<BinaryTree<T>> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<BinaryTree<T>>();
		   /* Levels are always traversed in order. So., if this is the
			* first time we've visited level i, we must have seen levels
			* 0 through i - 1. We can therefore safely add the level at
			* the end. */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.leftChild, lists, level + 1);
		createLevelLinkedList(root.rightChild, lists, level + 1);
	}
	
	public static boolean checkBST(BinaryTree<Integer> n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkBST(BinaryTree<Integer> n, int min, int max) {
		if(n == null) return true;
		if(n.data <= min || n.data > max) return false;
		if(!checkBST(n.leftChild, min, n.data) || !checkBST(n.rightChild, n.data, max))
			return false;
		return true;
	}
	
	public static void printZeroSumPaths(BinaryTree<Integer> root, int[] elements, int level) {
		if(root == null) return;
		elements[level] = root.data;
		if(isZeroSum(elements)) printPath(elements);
		printZeroSumPaths(root.leftChild, elements, level + 1);
		printZeroSumPaths(root.rightChild, elements, level + 1);
		elements[level] = 0;
	}
	
	public static boolean isZeroSum(int[] elements) {
		int sum = 0;
		for(int e : elements) {
			sum = sum + e;
		}
		if(sum == 0) return true;
		return false;
	}
	
	public static void printPath(int[] elements) {
		for(int e : elements) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static BinaryTree<Integer> findFirstCommonAncestor(BinaryTree<Integer> root,
		int val1, int val2) {
		if(root.leftChild.hasNode(val1) && root.leftChild.hasNode(val2))
			return findFirstCommonAncestor(root.leftChild, val1, val2);
		if(root.rightChild.hasNode(val1) && root.rightChild.hasNode(val2))
			return findFirstCommonAncestor(root.rightChild, val1, val2);
		return root;
	}
	
	public BinaryTree<Integer> findInorderSuccessor(ParentLinkedBinaryTree<Integer> node) {
		if(node == null) return null;
		/* Found right children -> return leftmost node of right
		 * subtree. */
		if(node.rightChild != null) return node.rightChild.getLeftmostChild();
		else {
			BinaryTree<Integer> q = node;
			BinaryTree<Integer> x = ((ParentLinkedBinaryTree<Integer>)q).getParent();
			// Go up until we're on left instead of right
			while (x != null && x.leftChild != q) {
				q = x;
				x = ((ParentLinkedBinaryTree<Integer>)x).getParent();
			}
			return x;
		}
	}
}
