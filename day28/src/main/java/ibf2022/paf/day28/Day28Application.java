package ibf2022.paf.day28;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2022.paf.day28.repositories.CommentRepository;

@SpringBootApplication
public class Day28Application implements CommandLineRunner {

	@Autowired
	private CommentRepository commentRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day28Application.class, args);
	}

	@Override
	public void run(String... args) {

		List<Document> results = commentRepo.searchCommentText("enjoyed", "loved", "super");

		for (Document d: results) 
			System.out.printf(">>> %s\n", d.toJson());
	}
}
