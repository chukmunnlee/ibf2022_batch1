package ibf2022.paf.day28.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import static ibf2022.paf.day28.Constants.*;

@Repository
public class CommentRepository {

	@Autowired 
	@Qualifier(BGG)
	private MongoTemplate template;

	/*
			db.comments.find(
				{ 
					$text: {
						$search: "words"
					}
				},
				{
					textScore: {
						$meta: "textScore"
					}
				}
			)
	 */
	public List<Document> searchCommentText(String... texts) {

		for (int i = 0; i < texts.length; i++) 
			System.out.printf(">>> texts[%d]: %s\n", i, texts[i]);

		TextCriteria criteria = TextCriteria.forDefaultLanguage()
				.matchingAny(texts);

		TextQuery textQuery = TextQuery.queryText(criteria)
				// Use this for method chaining
				.includeScore(FIELD_TEXT_SCORE)
				.sortByScore();

		//textQuery.setScoreFieldName(FIELD_TEXT_SCORE);

		Query  query = textQuery.limit(3);

		return template.find(query, Document.class, COLLECTION_COMMENTS);
	}
}
