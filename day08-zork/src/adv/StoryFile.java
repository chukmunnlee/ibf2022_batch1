package adv;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StoryFile {

	private String startRoom = "xxyyzz";
	private Map<String, Room> rooms = new HashMap<>();

	public void setStartRoom(String startRoom) { this.startRoom = startRoom; }
	public String getStartRoom() { return this.startRoom; }

	public void setRooms(Map<String, Room> rooms) { this.rooms = rooms; }
	public Map<String, Room> getRooms() { return this.rooms; }
	public void addRoom(Room room) {
		rooms.put(room.getName(), room);
	}
	public Optional<Room> getRoom(String direction) {
		if (rooms.containsKey(direction))
			return Optional.of(rooms.get(direction));
		return Optional.empty();
	}
}
