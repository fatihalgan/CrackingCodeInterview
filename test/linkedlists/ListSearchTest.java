package linkedlists;

import org.junit.Test;

import junit.framework.Assert;

public class ListSearchTest {

	private static final int[] elements = new int[] {2, 1, 8, 4, 7, 0, 5, 4, 6, 2};
	private static final int[] palindrome = new int[] {0, 1, 2, 1, 0};
	private static final int[] palindrome2 = new int[] {0, 1, 1, 0};
	private static final int[] palindrome3 = new int[] {0, 1, 0};
	
	@Test
	public void testGetLastKthElement() {
		Node<Integer> list = new Node<Integer>(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			list.appendToTail(elements[i]);
		}
		ListSearch.getKthLastElement(list, 3);
	}
	
	@Test
	public void testGetLastKthElementWithNode() {
		Node<Integer> list = new Node<Integer>(elements[0]);
		for(int i = 1; i < elements.length; i++) {
			list.appendToTail(elements[i]);
		}
		IndexedElementWrapper result = ListSearch.getKthLastElement(new IndexedElementWrapper(list, 3));
		Assert.assertEquals(result.getNode().data, 4);
	}
	
	@Test
	public void testIsPalindrome() {
		Node<Integer> list = new Node<Integer>(palindrome[0]);
		for(int i = 1; i < palindrome.length; i++) {
			list.appendToTail(palindrome[i]);
		}
		Assert.assertTrue(ListSearch.isPalindrome(list));
	}
	
	@Test
	public void testIsPalindrome2() {
		Node<Integer> list = new Node<Integer>(palindrome2[0]);
		for(int i = 1; i < palindrome2.length; i++) {
			list.appendToTail(palindrome2[i]);
		}
		Assert.assertTrue(ListSearch.isPalindrome(list));
	}
	
	@Test
	public void testIsPalindrome3() {
		Node<Integer> list = new Node<Integer>(palindrome3[0]);
		for(int i = 1; i < palindrome3.length; i++) {
			list.appendToTail(palindrome3[i]);
		}
		Assert.assertTrue(ListSearch.isPalindrome(list));
	}
}
