package objectoriented.carddeck;

public enum Suit {

	Club (0), Diamond (1), Heart (2), Spade (3);
	private int value;
	
	private Suit(int v) { value = v; }
	
	public int getValue() { return value; }
	
	public static Suit getSuitFromValue(int value) { 
		if(value == 0) return Club;
		if(value == 1) return Suit.Diamond;
		if(value == 2) return Suit.Heart;
		if(value == 3) return Spade;
		return null;
	}
}
