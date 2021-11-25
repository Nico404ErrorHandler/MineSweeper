
public class Score {
	
	int time;
	String playerName;
	
	public Score(String spielername, int zeit) {
		this.time = zeit;
		this.playerName = spielername;
	}
	
	public String getName() {
		return this.playerName;
	}
	
	public int getTime() {
		return this.time;
	}
	
}
