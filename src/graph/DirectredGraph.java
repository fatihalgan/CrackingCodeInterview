package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DirectredGraph<T> implements Iterable<Vertex<T>> {

	private final Map<Vertex<T>, Set<Vertex<T>>> mGraph = new HashMap<>();
	
	private Vertex<T> getNode(T val) {
		Set<Vertex<T>> keys = mGraph.keySet();
		for(Vertex<T> key : keys) {
			if(key.getData().equals(val)) return key;
		}
		return null;
	}
		
	public boolean addNode(T node) {
		Vertex<T> v = new Vertex<T>(node);
		if(mGraph.containsKey(v)) return false;
		mGraph.put(v, new HashSet<Vertex<T>>());
		return true;
	}
	
	public void addEdge(T start, T dest) {
		Vertex<T> vstart = new Vertex<T>(start);
		Vertex<T> vdest = new Vertex<T>(dest);
		if(!mGraph.containsKey(vstart) || !mGraph.containsKey(vdest)) {
			throw new NoSuchElementException("Both nodes must be in the graph.");
		}
		vstart = getNode(start);
		vdest = getNode(dest);
		mGraph.get(vstart).add(vdest);
	}
	
	public void removeEdge(T start, T dest) {
		Vertex<T> vstart = new Vertex<T>(start);
		Vertex<T> vdest = new Vertex<T>(dest);
		/* Confirm both endpoints exist. */
		if(!mGraph.containsKey(vstart) || !mGraph.containsKey(vdest)) {
			throw new NoSuchElementException("Both nodes must be in the graph.");
		}
		vstart = getNode(start);
		vdest = getNode(dest);
		mGraph.get(vstart).remove(vdest);	
    }
	
	public boolean edgeExists(T start, T dest) {
        /* Confirm both endpoints exist. */
		Vertex<T> vstart = new Vertex<T>(start);
		Vertex<T> vdest = new Vertex<T>(dest);
        if (!mGraph.containsKey(vstart) || !mGraph.containsKey(vdest))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        return mGraph.get(vstart).contains(vdest);
    }
	
	public Set<Vertex<T>> edgesFrom(T node) {
		Vertex<T> vstart = new Vertex<T>(node);
		Set<Vertex<T>> arcs = mGraph.get(vstart);
		if(arcs == null) throw new NoSuchElementException("Source node does not exist.");
		return arcs;
	}
	
	
	
	/**
     * Returns an iterator that can traverse the nodes in the graph.
     *
     * @return An iterator that traverses the nodes in the graph.
     */
    public Iterator<Vertex<T>> iterator() {
        return mGraph.keySet().iterator();
    }
    
    public boolean hasRoute(T start, T dest) {
    	Vertex<T> vstart = new Vertex<T>(start);
    	Vertex<T> vdest = new Vertex<T>(dest);
    	if(!mGraph.containsKey(vstart)) throw new NoSuchElementException("Source node does not exist");
    	if(!mGraph.containsKey(vdest)) throw new NoSuchElementException("Destination node does not exist");
    	vstart = getNode(start);
    	vdest = getNode(dest);
    	if(vdest.equals(vstart)) return true;
    	if(vstart.isVisited()) return false;
    	vstart.setVisited(true);
    	Set<Vertex<T>> neighbors = edgesFrom(vstart.getData());
    	for(Vertex<T> neighbor : neighbors) {
    		if(!neighbor.isVisited()) {
    			if(hasRoute(neighbor.getData(), dest)) return true;
    		}
    	}
    	return false;
    }
    
    
}
