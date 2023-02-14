package vttp2022.paf.day27.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

	@Value("${mongo.url}")
	private String mongoUrl;

	/*
	@Bean
	public MongoTemplate createTemplate() {
		return null;
	}
	*/
}
