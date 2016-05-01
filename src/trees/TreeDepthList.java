package trees;

import java.util.LinkedList;

public class TreeDepthList<T> {

	private LinkedList<T>[] list = new LinkedList[100];
	
	public void addToIndex(T element, int index) {
		if(list[index] == null) list[index] = new LinkedList<T>();
		list[index].addLast(element);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(LinkedList<T> innerList : list) {
			builder.append("[");
			for(T elem : innerList) {
				builder.append(elem + ",");
			}
			builder.append("]\n");
		}
		return builder.toString();
	}
}
