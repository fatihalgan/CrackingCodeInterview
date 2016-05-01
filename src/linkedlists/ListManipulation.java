package linkedlists;

public class ListManipulation {

	//implement an algortihm  to delete a node in the middle of a singly linked list
	//given only access to that node
	//input: the node c from the linked ist a -> b -> c -> d -> e
	//Result: nothing returned, but the new linked list looks like a -> b -> d -> e
	public static void removeElement(Node<Integer> list) {
		//Copy the next elements data value onto this element
		Integer nextVal = list.next.data;
		list.data = nextVal;
		//Then delete the next element
		Node nextElem = list.next.next;
		list.next.next = null;
		list.next = nextElem;
	}
	
	//Write code to partition a linked list around a value x such that all nodes less
	//then x come before all nodes greater than or equal to x
	public static Node<Integer> partition(Node<Integer> list, int x) {
		Node<Integer> small = null;
		Node<Integer> big = null;
		Node<Integer> match = null;
		Node<Integer> smallTail = null;
		Node<Integer> bigTail = null;
		while(list != null) {
			Node<Integer> temp = new Node(list.data);
			if(temp.data > x) {
				if(big == null) big = bigTail = temp;
				else bigTail.appendTo(bigTail, temp);
				bigTail = temp;
			} else if(temp.data < x){
				if(small == null) small = smallTail = temp;
				else smallTail.appendTo(smallTail, temp);
				smallTail = temp;
			} else {
				match = temp;
			}
			list = list.next;
		}
		if(match != null) {
			smallTail.appendTo(smallTail, match);
			match.appendTo(match, big);
		} else {
			smallTail.appendTo(smallTail, big);
		}		
		return small;
	}
	
	public static Node<Integer> addNumbers(Node<Integer> first, Node<Integer> second) {
		Node<Integer> result = null;
		int carry = 0;
		while(first != null && second != null) {
			Integer firstVal = first.data;
			Integer secondVal = second.data;
			int total = firstVal + secondVal + carry;
			int remainder = total % 10;
			if(result == null) {
				result = new Node<Integer>(remainder);
			}
			else result.appendToTail(remainder);
			carry = total / 10;
			first = first.next;
			second = second.next;
		}
		while(first != null) {
			Integer firstVal = first.data;
			int total = firstVal + carry;
			result.appendToTail(total);
			carry = 0;
			first = first.next;
		}
		while(second != null) {
			Integer secondVal = second.data;
			int total = secondVal + carry;
			result.appendToTail(total);
			carry = 0;
			second = second.next;
		}
		return result;
	}
	
	
}
