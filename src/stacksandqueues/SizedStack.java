package stacksandqueues;

import java.util.Stack;

public class SizedStack<T> extends Stack<T> {

	private static final long serialVersionUID = -2733186211679411433L;
	
	private int size;
	
	public SizedStack(int size) {
		this.size = size;
	}
	
	public T push(T element) {
		super.push(element);
		size++;
		return element;
	}
	
	public T pop() {
		if(super.peek() != null) size--;
		return super.pop();
	}
}
