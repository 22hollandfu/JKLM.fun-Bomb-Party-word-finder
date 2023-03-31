import java.util.*;
import java.io.*;

public class Game {

	public File file;
	public Scanner scanner;
	public Scanner sc;
	public ArrayList<String> foundWords;
	public ArrayList<String> specialWords;
	public boolean wordFound;
	public String neededLetter;

	public Game() {
		file = new File("C:\\Users\\dupaw\\Desktop\\Java Workspace\\Wordgame bot\\wordgame.txt");
		scanner = new Scanner(System.in);
		foundWords = new ArrayList<String>();
		specialWords = new ArrayList<String>();
		neededLetter = "q";
	}

	public void wordOut() {
		try {
			sc = new Scanner(file);
		} catch(FileNotFoundException e) {
			System.out.println("no file");
		}
		String phrase = scanner.nextLine();
		int len = phrase.length();
		if(len > 3)
			if(phrase.substring(0, 4).equals("need"))
				neededLetter = phrase.substring(len - 1);
		wordFound = false;
		boolean wordAlreadyFound = false;
		foundWords.clear();
		specialWords.clear();
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				for(int i = 0; i <= s.length() - len; i++) 
					if(s.substring(i, i + len).equals(phrase)) {
							foundWords.add(s);
							for(int j = 0; j < s.length(); j++)
								if(s.substring(j, j + 1).equals(neededLetter))
									specialWords.add(s);
							wordFound = true;
							break;
					}
			}
		System.out.println(foundWords);
		System.out.println(specialWords);
		if(!wordFound)
			System.out.println("no words found to match");
		wordOut();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.wordOut();
	}
}