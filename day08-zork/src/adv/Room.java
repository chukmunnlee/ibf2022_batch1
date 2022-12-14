package adv;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Room {
	private final String id;
	private String name;
	private String description;
	private Map<String, String> directions = new HashMap<>();

	public Room(String id) { this.id = id; }

	public String getId() { return this.id; }

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setDescription(String description) { this.description = description; }
	public String getDescription() { return this.description; }

	public void setDirections(Map<String, String> directions) { this.directions = directions; }
	public Map<String, String> getDirections() { return this.directions; }
	public void addDirection(String direction, String destination) {
		this.directions.put(direction, destination);
	}
	public Optional<String> go(String direction) {
		if (directions.containsKey(direction))
			return Optional.of(directions.get(direction));
		return Optional.empty();
	}
}
