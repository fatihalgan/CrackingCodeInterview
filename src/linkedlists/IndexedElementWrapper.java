package linkedlists;

public class IndexedElementWrapper {

	private Node node;
	private int index;
	
	public IndexedElementWrapper(Node node, int index) {
		this.node = node;
		this.index = index;
	}

	public Node getNode() {
		return node;
	}

	public int getIndex() {
		return index;
	}
	
	public void increment() {
		index++;
	}
}
