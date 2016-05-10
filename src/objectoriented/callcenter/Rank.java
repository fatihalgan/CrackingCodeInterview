package objectoriented.callcenter;

public enum Rank {
	Responder(0), Director(1), Manager(2);
	
	private int value;
	
	private Rank(int v) {
		value = v;
	}
	
	public int getValue() { return value; }
	
	public static Rank getRankFromValue(int value) { 
		if(value == 0) return Responder;
		if(value == 1) return Director;
		if(value == 2) return Manager;
		return null;
	}
}
