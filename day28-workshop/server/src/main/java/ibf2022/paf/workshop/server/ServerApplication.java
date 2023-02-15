package ibf2022.paf.workshop.server;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2022.paf.workshop.server.repositories.AppsRepository;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

	@Autowired
	private AppsRepository appsRepo;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		List<Document> results = appsRepo.getApplicationsByCategory();
		for (Document d: results)
			System.out.printf(">> %s\n", d.toJson());
	}

}
