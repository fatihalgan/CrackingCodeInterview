package linkedlists;

import org.junit.Test;

public class SortedNodeTest {

	private static final int[] elements = new int[] {2, 1, 8, 4, 7, 0, 5, 4, 6, 2};
	
	@Test
	public void testSortedNode() {
		SortedNode<Integer> list = new SortedNode<Integer>(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			list = list.append(elements[i]);
		}
		System.out.println(list.toString());
	}
}
