package trees;

public class ParentLinkedBinaryTree<T> extends BinaryTree<T> {

	private BinaryTree<T> parent = null;
	
	public ParentLinkedBinaryTree(T d, BinaryTree<T> parent) {
		super(d);
		this.parent = parent;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}
	
}
