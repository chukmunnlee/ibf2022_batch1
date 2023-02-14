package vttp2022.paf.day27.repositories;

public class Queries {

	public static final String SQL_SELECT_GAMES = """
		select gid, name from game limit ? offset ?
	""";

	public static final String SQL_SELECT_GAME_BY_GID = """
		select * from game where gid = ?
	""";
}
