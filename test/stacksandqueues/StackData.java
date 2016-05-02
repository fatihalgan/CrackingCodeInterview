package stacksandqueues;

/*
 * Part of the following problem:
 * Describe how you could use a single array to implement three stacks.
 */

/* StackData is a simple class that holds a set of data about each
 * stack. It does not hold the actual items in the stack. */
public class StackData {

	public int start;
	public int pointer;
	public int size = 0;
	public int capacity;
	
	public StackData(int _start, int _capacity) {
		start = _start;
		pointer = _start - 1;
		capacity = _capacity;
	}
	
	public boolean isWithinStack(int index, int total_size) {
		/* Note: if stack wraps, the head (right side) wraps around
		 * to the left. */
		if(start <= index && index < start + capacity) {
			// non-wrapping, or "head" (right side) of wrapping case
			return true;
		} else if(start + capacity > total_size && index < (start + capacity) % total_size) {
			// tail (left side) of wrapping case
			return true;
		}
		return false;
	}
	
	
}
