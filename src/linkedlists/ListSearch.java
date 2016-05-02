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
	
	//Given a circular linked list, implement an algorithm wihch returns the node
	//at the beginning of the loop
	// A -> B -> C -> D -> E -> C (The same C as earlier) Output: C
	//Solution:
	// 1 - Create two pointers, FastPointer and SlowPointer
	// 2 - Move fast pointer at a rate of 2 steps and SlowPointer at a rate of 1 step
	// 3 - When they collide, move SlowPointer to LinkedListHead. Keep fast pointer where it is
	// 4 - Move fast pointer and slow pointer at a rate of 1 step. Return the new collision point.
	Node<Integer> findBeginning(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		/* Find meeting point. This will be LOOP_SIZE - k steps into the
		 * linked list. */
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		
		/* Error check - no meeting point, and therefore no loop */
		if (fast == null || fast.next == null) {
			return null;
		}
		
		/* Move slow to Head. Keep fast at Meeting Point. Each are k
		 * steps from the Loop Start. If they move at the same pace,
		 * they must meet at Loop Start. */
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		/* Both now point to the start of the loop. */
		return fast;
	}
	
}
