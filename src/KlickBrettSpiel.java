
public interface KlickBrettSpiel {
	final char UNGEKLICKT = '.';

	void set(int x, int y);

	void markiere(int x, int y);

	char get(int x, int y);

	boolean gewonnen();

	boolean verloren();

	int getZeilenZahl();

	int getSpaltenZahl();
}