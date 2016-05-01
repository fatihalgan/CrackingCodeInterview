package stacksandqueues;

import java.util.Stack;

public class StackWithMin<T extends Comparable<T>> extends Stack<T> {

	private Stack<T> minElements = null;
	
	public StackWithMin() {
		super();
		minElements = new Stack<>();
	}
	
	@Override
	public T push(T element) {
		super.push(element);
		trackMinimumPush(element);
		return element;
	}
	
	public T pop(T element) {
		trackMinimumPop(element);
		return super.pop();
	}
	
	public T min() {
		return minElements.peek();
	}
	
	private void trackMinimumPush(T element) {
		T current = minElements.pop();
		if(current == null) {
			minElements.push(element);
		    return;
		}
		if(element.compareTo(current) < 0) minElements.push(element);
	}
	
	private void  trackMinimumPop(T element) {
		T current = minElements.pop();
		if(element.compareTo(current) == 0) minElements.pop();
		return;
	}
}
