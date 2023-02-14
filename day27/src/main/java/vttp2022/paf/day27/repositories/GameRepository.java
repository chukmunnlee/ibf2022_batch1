package vttp2022.paf.day27.repositories;

import java.util.List;
import java.util.Optional;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.day27.models.Game;

import static vttp2022.paf.day27.repositories.Queries.*;

@Repository
public class GameRepository {

	@Autowired
	private JdbcTemplate template;

	public Optional<Game> getGameByGameId(int gameId) {

		SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_BY_GID, gameId);

		if (!rs.next())
			return Optional.empty();

		return Optional.of(Game.create(rs));
	}

	// gid, name
	public List<Game> getGames() {
		return getGames(30, 0);
	}
	public List<Game> getGames(int limit, int offset) {

		SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAMES, limit, offset);

		List<Game> games = new LinkedList<>();
		while (rs.next())
			games.add(Game.createSummary(rs));

		return games;
	}
}
