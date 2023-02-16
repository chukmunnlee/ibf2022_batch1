package ibf2022.paf.day29;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2022.paf.day29.services.TvShowService;

@SpringBootApplication
public class Day29Application implements CommandLineRunner {

	@Autowired 
	private TvShowService tvshowSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day29Application.class, args);
	}

	@Override
	public void run(String... args) {
	}

}
