package adv;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Parser parser = new Parser(args[0]);
		StoryFile storyFile = parser.parse();

		Play play = new Play(storyFile);
		play.start();
	}
}
