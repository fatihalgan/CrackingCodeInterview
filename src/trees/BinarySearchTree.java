package trees;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	public BinarySearchTree(T d) {
		super(d);
	}

	public void setLeftChild(BinaryTree<T> leftChild) {
		if(leftChild.data.compareTo(this.data) > 0) 
			throw new IllegalArgumentException("Cannot add bigger element to left child");
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BinaryTree<T> rightChild) {
		if(rightChild.data.compareTo(this.data) <= 0) 
			throw new IllegalArgumentException("Cannot add smaller element to right child");
		this.rightChild = rightChild;
	}
	
	public BinaryTree<T> addLeftChild(T d) {
		if(d.compareTo(this.data) > 0) 
			throw new IllegalArgumentException("Cannot add bigger element to left child");
		this.leftChild = new BinaryTree<T>(d);
		return this;
	}
	
	public BinaryTree<T> addRightChild(T d) {
		if(d.compareTo(this.data) <= 0) 
			throw new IllegalArgumentException("Cannot add smaller element to right child");
		this.rightChild = new BinaryTree<T>(d);
		return this;
	}
	
	
}
