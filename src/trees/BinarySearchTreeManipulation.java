package trees;

public class BinarySearchTreeManipulation {

	//Given a sorted (increasing order) array with unique integer elements, 
	//write an algorithm
	//to create a binary search tree with minimal height
	public static BinaryTree<Integer> createBinarySearchTree(int[] source) {
		if(source == null) return null;
		if(source.length == 0) return null;
		if(source.length == 1) return new BinaryTree<Integer>(source[0]);
		int rootIndex = (source.length - 1) / 2;
		BinaryTree<Integer> root = new BinaryTree<Integer>(source[rootIndex]);
		root.leftChild = createBinarySearchTree(subarray(source, 0, rootIndex - 1));
		root.rightChild = createBinarySearchTree(subarray(source, rootIndex + 1, source.length - 1));
		return root;
	}
	
	private static int[] subarray(int[] source, int startIndex, int endIndex) {
		if(endIndex < startIndex) return null;
		int[] result = new int[endIndex - startIndex + 1];
		for(int i = 0; i < result.length ; i++) {
			result[i] = source[startIndex + i];
		}
		return result;
	}
}
