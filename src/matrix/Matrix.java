package matrix;

public class Matrix {
	
	public static void main(String[] args) {
		int[][] source = new int[][] {{1, 2, 3}, {4, 5, 6}};
		int[][] target = transpose(source);
		for(int i = 0; i < target.length; i++) {
			for(int k = 0; k < target[0].length; k++) {
				System.out.print(target[i][k] + " ");
			}
			System.out.println();
		}
	}

	//Rotate a matrix 90 degrees
	public static int[][] transpose(int[][] source) {
		int[][] target = new int[source[0].length][source.length];
		for(int i = 0; i < source.length; i++) {
			for(int k = 0; k < source[0].length; k++) {
				target[k][source.length - i - 1] = source[i][k];
			}
		}
		return target;
	}
	
	//Set the entire column and row of a matrix to zero where an element is zero.
	public static int[][] setColAndRowToZero(int[][] source) {
		boolean[] zeroRows = new boolean[source.length];
		boolean[] zeroCols = new boolean[source[0].length];
		
		for(int i = 0; i < source.length; i++) {
			for(int k = 0; k < source[0].length; k++) {
				if(source[i][k] == 0) {
					zeroRows[i] = true;
					zeroCols[k] = true;
				}
			}
		}
		
		for(int i = 0; i < source.length; i++) {
			for(int k = 0; k < source[0].length; k++) {
				if(zeroRows[i] || zeroCols[k]) source[i][k] = 0; 
			}
		}
		return source;
	}
	
}
