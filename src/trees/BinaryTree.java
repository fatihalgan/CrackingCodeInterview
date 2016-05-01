package trees;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class BinaryTree<T> {

	T data;
	BinaryTree<T> leftChild;
	BinaryTree<T> rightChild;
	
	public BinaryTree(T d) {
		this.data = d;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTree<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTree<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTree<T> rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTree<T> addLeftChild(T d) {
		this.leftChild = new BinaryTree<T>(d);
		return this;
	}
	
	public BinaryTree<T> addRightChild(T d) {
		this.rightChild = new BinaryTree<T>(d);
		return this;
	}
	
	//First parent, then left child then right child
	public void traversePreorder(Consumer<T> op) {
		op.accept(this.getData());
		if(leftChild != null) leftChild.traversePreorder(op);
		if(rightChild != null) rightChild.traversePreorder(op);
	}
	
	public void traverseInOrder(Consumer<T> op) {
		if(leftChild != null) leftChild.traverseInOrder(op);
		op.accept(this.getData());
		if(rightChild != null) rightChild.traverseInOrder(op);
	}
	
	public void traversePostOrder(Consumer<T> op) {
		if(leftChild != null) leftChild.traversePostOrder(op);
		if(rightChild != null) rightChild.traversePostOrder(op);
		op.accept(this.getData());
	}
	
	public void traverseDepthOrder(Consumer<T> op) {
		Queue<BinaryTree<T>> q = new ConcurrentLinkedQueue<>();
		q.add(this);
		while(!q.isEmpty()) {
			BinaryTree<T> node = q.remove();
			op.accept(node.getData());
			if(node.leftChild != null) {
				q.add(node.leftChild);
			}
			if(node.rightChild != null) {
				q.add(node.rightChild);
			}
		}
	}
	
	public int getHeight() {
		if(leftChild == null && rightChild == null) return 1;
		return Math.max(leftChild.getHeight(), rightChild.getHeight()) + 1;
	}
	
	//Not efficient, calculates height for the same nodes over and over again
	public boolean isBalanced() {
		int heightDiff = leftChild.getHeight() - rightChild.getHeight();
		if(Math.abs(heightDiff) > 1) return false;
		return leftChild.isBalanced() && rightChild.isBalanced();
	}
	
	//More efficient, checks if balanced while calculating height of each node.
	//Returns -1 if not balanced, returns height otherwise
	public int checkHeight() {
		if(leftChild == null && rightChild == null) return 1;
		int leftHeight = leftChild.getHeight();
		if(leftHeight == -1) return -1; //Not Balanced
		int rightHeight = rightChild.getHeight();
		if(rightHeight == -1) return -1;
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1) return -1;
		else return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public boolean isBalancedEfficient() {
		if(checkHeight() == -1) return false;
		return true;
	}
	
	public boolean isIdentical(BinaryTree<T> other) {
		if(!other.data.equals(data)) return false;
		if(leftChild == null && other.leftChild == null) return true;
		if(rightChild == null && other.rightChild == null) return true;
		if(leftChild == null && other.leftChild != null) return false;
		if(rightChild == null && other.rightChild != null) return false;
		if(other.leftChild == null && leftChild != null) return false;
		if(other.rightChild == null && rightChild != null) return false;
		return leftChild.isIdentical(other.leftChild) && rightChild.isIdentical(other.rightChild);
	}
	
	public boolean isSubTree(BinaryTree<T> other) {
		if(isIdentical(other)) return true;
		if(leftChild != null && leftChild.isSubTree(other)) return true;
		if(rightChild != null && rightChild.isSubTree(other)) return true;
		return false;
	}
	
	public boolean hasNode(T value) {
		if(data.equals(value)) return true;
		if(leftChild != null && rightChild != null) 
			return leftChild.hasNode(value) || rightChild.hasNode(value);
		if(leftChild == null) return rightChild.hasNode(value);
		if(rightChild == null) return leftChild.hasNode(value);
		return false;
	}
	
	public BinaryTree<T> getLeftmostChild() {
		if(leftChild == null) return this;
		while(leftChild != null) return getLeftmostChild();
		return null;
	}
}
