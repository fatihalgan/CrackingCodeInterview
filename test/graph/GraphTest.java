package graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class GraphTest {

	private static final char[] elements = new char[] {'A', 'B', 'C', 'D', 'E', 'F'};
	private DirectredGraph<Character> graph = new DirectredGraph<>();
	
	@Before
	public void setUp() {
		for(Character c : elements) {
			graph.addNode(c);
		}
		graph.addEdge('A', 'B');
		graph.addEdge('B', 'D');
		graph.addEdge('D', 'C');
		graph.addEdge('D', 'A');
		graph.addEdge('D', 'F');
		graph.addEdge('E', 'D');
		graph.addEdge('E', 'F');		
	}
	
	@Test
	public void testHasRoute() {
		Assert.assertTrue(graph.hasRoute('A', 'F'));
		Assert.assertFalse(graph.hasRoute('A', 'E'));
	}
}
