package ibf2022.paf.day28.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.MongoExpression;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import static ibf2022.paf.day28.Constants.*;

import java.util.List;

@Repository
public class TvShowRepository {

	@Autowired @Qualifier(NETFLIX)
	private MongoTemplate template;

	/*
	 	db.tvshows.aggregate([
			{ 
				match$: { language: { $regex: 'english', $options: 'i' }
				}
			},
			{
				project$: { _id: 0, name: 1, url: 1, genres: 1 }
			}
		])
	 */
	public List<Document> find() {

		Criteria criteria = Criteria.where(FIELD_LANGUAGE).regex("english", "i");

		// $match
		MatchOperation matchLang = Aggregation.match(criteria);

		// $project
		ProjectionOperation project = Aggregation.project()
				.andExclude(FIELD_UNDERSCORE_ID)
				.andInclude(FIELD_URL, FIELD_NAME, FIELD_GENRES);

		// $limit
		LimitOperation limitResult = Aggregation.limit(3);

		Aggregation pipeline = Aggregation.newAggregation(
				// $match, $project, $limit
				matchLang, project, limitResult
		);

		AggregationResults<Document> results = template.aggregate(
				pipeline, COLLECTION_TVSHOWS, Document.class);

		return results.getMappedResults();
	}

	public List<Document> groupTvShowsByRuntime() {

		String push = """
				title: "$name",
				language: "$language"
		""";

		GroupOperation groupRuntime = Aggregation.group(FIELD_RUNTIME)
				//.push(push).as(FIELD_SHOWS)
				.push(FIELD_NAME).as(FIELD_SHOWS)
				.count().as(FIELD_TOTAL);

		Aggregation pipeline = Aggregation.newAggregation(groupRuntime);

		return template.aggregate(pipeline, COLLECTION_TVSHOWS, Document.class)
				.getMappedResults();
	}

	public List<Document> getTitleAndRating() {
		ProjectionOperation project = Aggregation.project()
			//.and(FIELD_NAME).as(FIELD_TITLE)
			.and(
					AggregationExpression.from(
						MongoExpression.create(CONCAT_NAME_AND_RUNTIME)
					)
			 ).as(FIELD_TITLE)
			.and(FIELD_AVG_RATING).as(FIELD_RATING)
			.andExclude(FIELD_UNDERSCORE_ID);

		Aggregation pipeline = Aggregation.newAggregation(project);

		return template.aggregate(pipeline, COLLECTION_TVSHOWS, Document.class)
				.getMappedResults();
	}
}
