package linkedlists;

import java.util.Comparator;

public class Node<T> {

	Node<T> next = null;
	T data;
	
	public Node(T d) {
		this.data = d;
	}
	
	public void appendToTail(T d) {
		Node<T> end = new Node<T>(d);
		Node<T> n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public Node<T> deleteNode(T d) {
		Node<T> n = this;
		if(n.data == d) return this.next;
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return this; //head didn't change
			}
			n = n.next;
		}
		return this;
	}
	
	public void appendTo(Node<T> node, Node<T> toInsert) {
		Node<T> next = node.next;
		node.next = toInsert;
		while(toInsert.next != null) toInsert = toInsert.next;
		toInsert.next = next;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		Node<T> pointer = this;
		while(pointer.next != null) {
			builder.append(pointer.data + ", ");
			pointer = pointer.next;
		}
		builder.append(pointer.data + "]");
		return builder.toString();
	}
	
	
}
