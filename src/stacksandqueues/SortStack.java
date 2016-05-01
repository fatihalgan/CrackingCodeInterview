package stacksandqueues;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sort(Stack<Integer> source) {
		Stack<Integer> target = new Stack<>();
		while(!source.isEmpty()) {
			Integer element = source.pop();
			if(target.isEmpty() || element >= target.peek()) target.push(element);
			else {
				while(!target.isEmpty() && element < target.peek()) {
					source.push(target.pop());
				}
				target.push(element);
			}
		}
		return target;		
	}
}
