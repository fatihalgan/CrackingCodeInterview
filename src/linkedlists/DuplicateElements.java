package linkedlists;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElements {

	//remove duplicate elements from an unsorted linked list
	public static Node<Integer> removeDuplicates(Node<Integer> list) {
		Map<Integer, Integer> duplicates = new HashMap<>();
		Node<Integer> pointer = list;
		while(pointer != null) {
			if(duplicates.containsKey(pointer.data)) {
				list = list.deleteNode(pointer.data);
			} else {
				duplicates.put(pointer.data, 1);
			}
			pointer = pointer.next;
		}
		return list;
	}
	
	//Remove duplicates without using a buffer
	public static Node<Integer> removeDuplicates2(Node<Integer> list) {
		Node<Integer> p1 = list;
		Node<Integer> p2 = list;
		while(p1 != null) {
			Integer val1 = p1.data;
			p2 = p1.next;
			while(p2 != null) {
				if(p2.data.equals(val1)) {
					list = list.deleteNode(val1);
				}
				p2 = p2.next;
			}
			p1 = p1.next;
		}
		return list;
	}
}
