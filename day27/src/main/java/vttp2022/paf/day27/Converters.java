package vttp2022.paf.day27;

import org.springframework.util.MultiValueMap;

import vttp2022.paf.day27.models.Comment;

public class Converters {

	public static Comment create(MultiValueMap<String, String> form) {
		Comment comment = new Comment();
		comment.setGameId(
			Integer.parseInt(form.getFirst("gameId"))
		);
		comment.setUsername(form.getFirst("username"));
		comment.setRating(
			Integer.parseInt(form.getFirst("rating"))
		);
		comment.setComment(form.getFirst("comment"));
		return comment;
	}
}
