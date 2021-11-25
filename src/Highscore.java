import java.util.ArrayList;

public class Highscore extends ArrayList<Score> {
	
	private static Highscore instanz = null;
	
	private Highscore() {
	}
	
	public static Highscore getInstance() {
		if(instanz == null) {
			instanz = new Highscore();
		} return instanz;
		
	}
}
