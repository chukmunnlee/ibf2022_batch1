package vttp2022.paf.day27.repositories;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.day27.models.Comment;

@Repository
public class CommentRepository {

	public static String COLLECTION_COMMENTS = "comments";

	@Autowired
	private MongoTemplate template;

	public void insertComment(Comment comment) {
		Document doc = comment.toDocument();
		template.insert(doc, COLLECTION_COMMENTS);
	}
}
