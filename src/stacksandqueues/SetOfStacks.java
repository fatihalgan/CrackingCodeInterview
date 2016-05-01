package stacksandqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import linkedlists.Node;

public class SetOfStacks<T> extends Stack<T> {

	private int capacity;
	private ArrayList<SizedStack<T>> list = new ArrayList<>();
	
	public SetOfStacks(int capacity) {
		if(capacity <= 0) throw new IllegalArgumentException("Stack capacity cannot be lower than 1");
		this.capacity = capacity;
	}
	
	public T push(T element) {
		if(list.isEmpty()) list.add(new SizedStack<>(capacity));
		SizedStack<T> currentStack = list.get(list.size() - 1);
		if(currentStack.size() == capacity) {
			list.add(new SizedStack<>(capacity));
			currentStack = list.get(list.size() - 1);
		}
		currentStack.push(element);
		return element;
	}
	
	public T pop() {
		if(list.isEmpty()) return null;
		SizedStack<T> currentStack = list.get(list.size() - 1);
		if(currentStack.isEmpty()) {
			list.remove(list.size() - 1);
			currentStack = list.get(list.size() - 1);
		}
		return currentStack.pop();		
	}
	
	public T popAt(int index) {
		if(index >= list.size() || list.get(index) == null) return null;
		SizedStack<T> currentStack = list.get(index);
		if(currentStack == null) return null;
		return currentStack.pop();
	}
	
}
