package vttp2022.paf.day27.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {

	private int gameId;
	private String name;

	public void setGameId(int gameId) { this.gameId = gameId; }
	public int getGameId() { return this.gameId; }

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public static Game createSummary(SqlRowSet rs) {
		Game game = new Game();
		game.setGameId(rs.getInt("gid"));
		game.setName(rs.getString("name"));
		return game;
	}
}

