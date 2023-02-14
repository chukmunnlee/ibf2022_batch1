package vttp2022.paf.day27.models;

import org.bson.Document;
import org.springframework.util.MultiValueMap;

public class Comment {

	private String commentId;
	private int gameId;
	private String userName;
	private int rating;
	private String comment;

	public void setCommentId(String commentId) { this.commentId = commentId; }
	public String getCommentId() { return this.commentId; }

	public void setGameId(int gameId) { this.gameId = gameId; }
	public int getGameId() { return this.gameId; }

	public void setUsername(String userName) { this.userName = userName; }
	public String getUsername() { return this.userName; }

	public void setRating(int rating) { this.rating = rating; }
	public int getRating() { return this.rating; }

	public void setComment(String comment) { this.comment = comment; }
	public String getComment() { return this.comment; }

	public Document toDocument() {
		Document doc = new Document();
		doc.put("c_id", getCommentId());
		doc.put("user", getUsername());
		doc.put("rating", getRating());
		doc.put("c_text", getComment());
		return doc;
	}

	@Override
	public String toString() {
		return "Comment[commentId=%s, username=%s, rating=%d, comment=%s]"
			.formatted(commentId, userName, rating, comment);
	}

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
