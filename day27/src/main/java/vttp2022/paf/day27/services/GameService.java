package vttp2022.paf.day27.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.paf.day27.models.Game;
import vttp2022.paf.day27.models.Comment;
import vttp2022.paf.day27.repositories.CommentRepository;
import vttp2022.paf.day27.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;

	@Autowired
	private CommentRepository commentRepo;

	public String addComment(Comment comment) {
		String commentId = UUID.randomUUID().toString().substring(0, 8);
		comment.setCommentId(commentId);
		commentRepo.insertComment(comment);
		return commentId;
	}

	public Optional<Game> getGameByGameId(int gameId) {
		return gameRepo.getGameByGameId(gameId);
	}

	public List<Game> getGames() {
		return getGames(30, 0);
	}
	public List<Game> getGames(int limit, int offset) {
		return gameRepo.getGames(limit, offset);
	}
}
