package linkedlists;

import org.junit.Test;

public class RemoveDuplicatesTest {

	private static final int[] elements = new int[] {2, 1, 8, 4, 7, 0, 5, 4, 6, 2};
	
	@Test
	public void testRemoveDuplicates() {
		Node<Integer> list = new Node<Integer>(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			list.appendToTail(elements[i]);
		}
		list = DuplicateElements.removeDuplicates(list);
		System.out.println(list.toString());
	}
	
	@Test
	public void testRemoveDuplicatesWithoutUsingBuffer() {
		Node<Integer> list = new Node<Integer>(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			list.appendToTail(elements[i]);
		}
		list = DuplicateElements.removeDuplicates2(list);
		System.out.println(list.toString());
	}
}
