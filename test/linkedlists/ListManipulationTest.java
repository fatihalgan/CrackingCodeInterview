package linkedlists;

import org.junit.Test;

public class ListManipulationTest {

	private static final int[] elements = new int[] {2, 1, 8, 4, 7, 0, 5, 4, 6, 2};
	
	@Test
	public void testPartitionList() {
		Node<Integer> list = new Node<Integer>(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			list.appendToTail(elements[i]);
		}
		list = ListManipulation.partition(list, 5);
		System.out.println(list);
	}
	
	@Test
	public void testAddNumbers() {
		Node<Integer> first = new Node<Integer>(7);
		first.appendToTail(1);
		first.appendToTail(6);
		Node<Integer> second = new Node<Integer>(5);
		second.appendToTail(9);
		second.appendToTail(2);
		Node<Integer> result = ListManipulation.addNumbers(first, second);
		System.out.println(result);
	}
	
}
