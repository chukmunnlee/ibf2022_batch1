package adv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static adv.Keywords.*;

public class Parser {

	private final String filename;

	public Parser(String filename) {
		this.filename = filename;
	}

	public StoryFile parse() throws IOException {

		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line;

		StoryFile storyFile = new StoryFile();
		Room currRoom = new Room("xxyyzz");

		while (null != (line = br.readLine())) {
			line = line.trim();
			if (line.length() <= 0)
				continue;

			String[] terms = line.split(":");

			switch (terms[0]) {
				case DESCRIPTION:
					parseDescription(currRoom, terms[1]);
					break;

				case DIRECTION:
					parseDirection(currRoom, terms[1]);
					break;

				case NAME:
					parseName(currRoom, terms[1]);
					break;

				case ROOM:
					currRoom = parseRoom(terms[1]);
					storyFile.addRoom(currRoom);
					break;

				case START:
					parseStart(storyFile, terms[1]);
					break;

				default:
					// Ignore line
			}
		}

		br.close();
		fr.close();

		return storyFile;
	}

	private void parseDescription(Room room, String description) {
		String converted = description.replaceAll(BREAK, "\n");
		room.setDescription(converted);
	}

	private void parseDirection(Room room, String data) {
		String terms[] = data.trim().split(" ");
		room.addDirection(terms[0].trim(), terms[1].trim());
	}

	private void parseName(Room room, String name) {
		room.setName(name);
	}

	private Room parseRoom(String id) {
		return new Room(id.trim());
	}

	private void parseStart(StoryFile storyFile, String startRoom) {
		storyFile.setStartRoom(startRoom.trim());
	}
}
