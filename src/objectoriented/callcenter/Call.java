package objectoriented.callcenter;

public class Call {

	/* Minimal rank of employee who can handle this call. */
	private Rank rank;
	
	/* Person who is calling. */
	private String caller;
	
	/* Employee who is handling call. */
	private Employee handler;
	
	public Call(String caller) {
		rank = Rank.Responder;
		this.caller = caller;
	}
	
	/* Set employee who is handling call. */
	public void setHandler(Employee e) { handler = e; }
	
	public void reply(String message) { }
	public Rank getRank() { return rank; }
	public void setRank(Rank r) { rank = r; }
	public Rank incrementRank() {  return null; }
	public void disconnect() {  }
}
