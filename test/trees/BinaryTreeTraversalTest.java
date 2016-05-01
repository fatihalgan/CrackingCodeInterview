package trees;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BinaryTreeTraversalTest {

	private static final int[] elements = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private BinaryTree<Integer> tree;
	
	@Before
	public void setUp() {
		tree = BinarySearchTreeManipulation.createBinarySearchTree(elements);
	}
	
	@Test
	public void testCheckIsBinarySearchTree() {
		Assert.assertTrue(BinaryTreeTraversal.checkBST(tree));
	}
	
	@Test
	public void testCheckSubtree() {
		BinaryTree<Integer> root = new BinaryTree<Integer>(1);
		root.leftChild = new BinaryTree<Integer>(3);
		root.rightChild = new BinaryTree<Integer>(5);
		root.leftChild.leftChild = new BinaryTree<Integer>(7);
		root.leftChild.leftChild.leftChild = new BinaryTree<Integer>(3);
		root.leftChild.rightChild = new BinaryTree<Integer>(6);
		root.leftChild.rightChild.leftChild = new BinaryTree<Integer>(5);
		root.leftChild.rightChild.rightChild = new BinaryTree<Integer>(4);
		root.leftChild.rightChild.leftChild.leftChild = new BinaryTree<Integer>(4);
		root.leftChild.rightChild.leftChild.rightChild = new BinaryTree<Integer>(2);
		root.rightChild.leftChild = new BinaryTree<Integer>(4);
		root.rightChild.rightChild = new BinaryTree<Integer>(2);
		Assert.assertTrue(root.leftChild.isSubTree(root.rightChild));
	}
	
	@Test
	public void testZeroSumPaths() {
		BinaryTree<Integer> root = new BinaryTree<Integer>(1);
		root.leftChild = new BinaryTree<Integer>(3);
		root.leftChild.leftChild = new BinaryTree<Integer>(-7);
		root.leftChild.rightChild = new BinaryTree<Integer>(-6);
		root.leftChild.leftChild.leftChild = new BinaryTree<Integer>(-3);
		root.leftChild.rightChild.leftChild = new BinaryTree<Integer>(2);
		root.leftChild.rightChild.rightChild = new BinaryTree<Integer>(3);
		root.leftChild.rightChild.leftChild.leftChild = new BinaryTree<Integer>(4);
		root.leftChild.rightChild.leftChild.rightChild = new BinaryTree<Integer>(2);
		root.leftChild.rightChild.leftChild.rightChild.rightChild = new BinaryTree<Integer>(-2);
				
		root.rightChild = new BinaryTree<Integer>(5);
		root.rightChild.leftChild = new BinaryTree<Integer>(-6);
		root.rightChild.rightChild = new BinaryTree<Integer>(2);
		root.rightChild.rightChild.rightChild = new BinaryTree<Integer>(-8);
		
		BinaryTreeTraversal.printZeroSumPaths(root, new int[1000], 0);
	}
}
