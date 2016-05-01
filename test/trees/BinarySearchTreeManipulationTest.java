package trees;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeManipulationTest {

	private static final int[] elements1 = {0};
	private static final int[] elements2 = {0, 1};
	private static final int[] elements3 = {0, 1, 2};
	private static final int[] elements4 = {0, 1, 2, 3};
	private static final int[] elements5 = {0, 1, 2, 3, 4};
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testCreateBinarySearchTree() {
		BinaryTree<Integer> tree = BinarySearchTreeManipulation.createBinarySearchTree(elements1);
		tree.traverseDepthOrder(System.out::println);
	}
	
	@Test
	public void testCreateBinarySearchTree2() {
		BinaryTree<Integer> tree = BinarySearchTreeManipulation.createBinarySearchTree(elements2);
		tree.traverseDepthOrder(System.out::println);
	}
	
	
	@Test
	public void testCreateBinarySearchTree3() {
		BinaryTree<Integer> tree = BinarySearchTreeManipulation.createBinarySearchTree(elements3);
		tree.traverseDepthOrder(System.out::println);
	}
	
	@Test
	public void testCreateBinarySearchTree4() {
		BinaryTree<Integer> tree = BinarySearchTreeManipulation.createBinarySearchTree(elements4);
		tree.traverseDepthOrder(System.out::println);
	}
	
	
	@Test
	public void testCreateBinarySearchTree5() {
		BinaryTree<Integer> tree = BinarySearchTreeManipulation.createBinarySearchTree(elements5);
		tree.traverseDepthOrder(System.out::println);
	}
}
