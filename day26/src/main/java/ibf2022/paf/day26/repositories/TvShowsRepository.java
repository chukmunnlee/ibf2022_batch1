package ibf2022.paf.day26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static ibf2022.paf.day26.Constants.*;

@Repository
public class TvShowsRepository {

    @Autowired
    private MongoTemplate template;

    /*
     * db.tvshows.find({ langage: "English" })
     */
    public List<Document> findTvShowsByLanguage(String lang) {
        // Create a criteria - { language: { $regex: 'english', $options: 'i' } }
        Criteria criterial = Criteria.where(FIELD_LANGUAGE).regex(lang, "i");

        // Create a query
        Query query = Query.query(criterial);

        // Perform the query
        /// List<Document> results 
        return template.find(query, Document.class, COLLECTION_TVSHOWS);
    }
    
}
