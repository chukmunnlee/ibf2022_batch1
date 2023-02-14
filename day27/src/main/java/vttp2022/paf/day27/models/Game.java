package vttp2022.paf.day27.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {

	private int gameId;
	private String name;
	private int ranking;
	private String url;
	private String image;

	public void setGameId(int gameId) { this.gameId = gameId; }
	public int getGameId() { return this.gameId; }

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setRanking(int ranking) { this.ranking = ranking; }
	public int getRanking() { return this.ranking; }

	public void setUrl(String url) { this.url = url; }
	public String getUrl() { return this.url; }

	public void setImage(String image) { this.image = image; }
	public String getImage() { return this.image; }

	public static Game createSummary(SqlRowSet rs) {
		Game game = new Game();
		game.setGameId(rs.getInt("gid"));
		game.setName(rs.getString("name"));
		return game;
	}

	public static Game create(SqlRowSet rs) {
		Game game = new Game();
		game.setGameId(rs.getInt("gid"));
		game.setName(rs.getString("name"));
		game.setRanking(rs.getInt("ranking"));
		game.setUrl(rs.getString("url"));
		game.setImage(rs.getString("image"));
		return game;
	}
}

