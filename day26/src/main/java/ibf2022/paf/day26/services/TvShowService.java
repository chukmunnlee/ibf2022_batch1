package ibf2022.paf.day26.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.paf.day26.models.TvShow;
import ibf2022.paf.day26.repositories.TvShowsRepository;

@Service
public class TvShowService {

    @Autowired
    private TvShowsRepository tvShowRepo;

	 public List<TvShow> getShowsByType(String type) {
		 return tvShowRepo.getShowsByType(type)
			 .stream()
			 .map(v -> TvShow.createSummary(v))
			 .toList();
	 }

    public List<String> getAllTypes() {
        return tvShowRepo.getTypes();
    }

    public List<TvShow> findAllTvShowsByLanguage(String lang) {
        return tvShowRepo.findTvShowsByLanguage(lang)
            .stream()
            .map(v -> TvShow.create(v))
            .toList();
    }
    
}
