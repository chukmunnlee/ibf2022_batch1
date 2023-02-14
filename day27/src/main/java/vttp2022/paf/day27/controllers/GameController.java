package vttp2022.paf.day27.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.paf.day27.models.Game;
import vttp2022.paf.day27.models.Comment;
import vttp2022.paf.day27.services.GameService;

@Controller
@RequestMapping(path="/game")
public class GameController {

	@Autowired
	private GameService gameSvc;

	@PostMapping("/comment")
	public String postComment(@RequestBody MultiValueMap<String, String> form) {
		Comment comment = Comment.create(form);
		String commentId = gameSvc.addComment(comment);
		System.out.printf(">>>> commentId: %s\n", commentId);
		return "redirect:/";
	}

	@GetMapping("/{gameId}")
	public String getGame(Model model, @PathVariable int gameId) {

		Optional<Game> opt = gameSvc.getGameByGameId(gameId);

		model.addAttribute("gameId", gameId);

		if (opt.isEmpty())
			return "not-found";

		model.addAttribute("game", opt.get());

		return "display-game";
	}
}
