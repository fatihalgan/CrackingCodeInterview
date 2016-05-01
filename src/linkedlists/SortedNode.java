package linkedlists;

public class SortedNode<T extends Comparable<T>> implements Comparable<SortedNode<T>> {

	SortedNode<T> next = null;
	T data;
	
	public SortedNode(T d) {
		this.data = d;
	}
	
	public SortedNode<T> append(T d) {
		SortedNode<T> newNode = new SortedNode<T>(d);
		SortedNode<T> current = this;
		SortedNode<T> head = this;
		SortedNode<T> previous = null;
		while(current != null) { 
			if(current.compareTo(newNode) >= 0) {
				if(previous != null) {
					previous.next = newNode;
					newNode.next = current;
				} else {
					previous = newNode;
					previous.next = current;
					head = previous;
				}
				return head;
			}
			previous = current;
			current = current.next;
		}
		previous.next = newNode;
		return head;
	}
	
	@Override
	public int compareTo(SortedNode<T> o) {
		return this.data.compareTo(o.data);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		SortedNode<T> pointer = this;
		while(pointer.next != null) {
			builder.append(pointer.data + ", ");
			pointer = pointer.next;
		}
		builder.append(pointer.data + "]");
		return builder.toString();
	}
}
