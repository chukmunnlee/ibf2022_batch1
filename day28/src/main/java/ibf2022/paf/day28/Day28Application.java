package ibf2022.paf.day28;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import ibf2022.paf.day28.repositories.CommentRepository;
import ibf2022.paf.day28.repositories.TvShowRepository;

import static ibf2022.paf.day28.Constants.*;

@SpringBootApplication
public class Day28Application implements CommandLineRunner {

	@Autowired @Qualifier(BGG)
	private CommentRepository commentRepo;

	@Autowired @Qualifier(NETFLIX)
	private TvShowRepository tvshowsRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day28Application.class, args);
	}

	@Override
	public void run(String... args) {

		//List<Document> results = commentRepo.searchCommentText("enjoyed", "loved", "super");
		//List<Document> results = tvshowsRepo.find();
		//List<Document> results = tvshowsRepo.groupTvShowsByRuntime();
		List<Document> results = tvshowsRepo.getTitleAndRating();

		for (Document d: results) 
			System.out.printf(">>> %s\n", d.toJson());
	}
}
