package ibf2022.paf.workshop.server.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoExpression;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import static ibf2022.paf.workshop.server.Constants.*;

@Repository
public class AppsRepository {

	@Autowired
	private MongoTemplate template;

	public List<Document> getApplicationsByCategory() {
		//Criteria criteria = Criteria.where(FIELD_RATING).is(Float.NaN);
		Criteria criteria = Criteria.where(FIELD_RATING).ne(Float.NaN);
		MatchOperation matchNonNaN = Aggregation.match(criteria);

		GroupOperation groupByCategory = Aggregation.group(FIELD_CATEGORY)
				.push(FIELD_APP).as(FIELD_APPS)
				//.avg(FIELD_RATING).as(FIELD_AVG_RATING);
				.and(FIELD_RATING, 
						AggregationExpression.from(
							MongoExpression.create("""
								$avg: "$Rating"
							""")
						)
				 );

		Aggregation pipeline = Aggregation.newAggregation(matchNonNaN, groupByCategory);
		//Aggregation pipeline = Aggregation.newAggregation(matchNonNaN);

		return template.aggregate(pipeline, COLLECTION_APPS, Document.class)
				.getMappedResults();
	}
}
