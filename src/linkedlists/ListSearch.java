package linkedlists;

import java.util.Stack;

public class ListSearch {

	public static int getKthLastElement(Node<Integer> node, int k) {
		if(node == null) return 0;
		int val = getKthLastElement(node.next, k) + 1;
		if(val == k) System.out.println(node.data);
		return val;
	}
	
	public static IndexedElementWrapper getKthLastElement(IndexedElementWrapper k) {
		if(k.getNode() == null) return new IndexedElementWrapper(k.getNode(), 0);
		IndexedElementWrapper val = getKthLastElement(new IndexedElementWrapper(k.getNode().next, k.getIndex()));
		val.increment();
		if(val.getIndex() == k.getIndex()) return new IndexedElementWrapper(k.getNode(), val.getIndex());
		return val;
	}
	
	public static boolean isPalindrome(Node<Integer> list) {
		Node<Integer> fast = list;
		Node<Integer> slow = list;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		/* Has odd number of elements, so skip the middle element */
		if (fast != null) {
			slow = slow.next;
		}
		while(slow != null) {
			int top = stack.pop();
			/* If values are different, then it's not a palindrome */
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
