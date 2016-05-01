package stacksandqueues;

import java.util.Stack;

import org.junit.Test;

public class SortStackTest {

	private static final int[] elements = new int[] {2, 1, 8, 4, 7, 0, 5, 4, 6, 2};
	
	@Test
	public void testSortStack() {
		Stack<Integer> stack = new Stack();
		for(int i : elements) {
			stack.push(i);
		}
		Stack<Integer> result = SortStack.sort(stack);
		while(!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}
}
