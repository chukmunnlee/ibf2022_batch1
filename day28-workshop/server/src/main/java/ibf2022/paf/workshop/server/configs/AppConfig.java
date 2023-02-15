package ibf2022.paf.workshop.server.configs;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static ibf2022.paf.workshop.server.Constants.*;

@Configuration
public class AppConfig {

	@Value("${mongo.url}")
	private String mongoUrl;

	@Bean
	public MongoDatabase createMongoClient() {
		// Create a client
		MongoClient client = MongoClients.create(mongoUrl);
		// Get a database
		MongoDatabase db = client.getDatabase(PLAYSTORE);
		// Get a collection
		MongoCollection<Document> apps = db.getCollection(COLLECTION_APPS);
		return db;
	}

	@Bean
	public MongoTemplate createTemplate() {
		return new MongoTemplate(MongoClients.create(mongoUrl), PLAYSTORE);
	}

}
