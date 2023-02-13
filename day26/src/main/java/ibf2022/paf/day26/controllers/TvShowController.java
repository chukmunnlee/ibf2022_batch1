package ibf2022.paf.day26.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.paf.day26.models.TvShow;
import ibf2022.paf.day26.services.TvShowService;

@Controller
@RequestMapping(path="/tvshow")
public class TvShowController {

    @Autowired
    private TvShowService tvshowSvc;

    // GET /tvshow?lang=English
    @GetMapping
    public String getTvShowByLanguage(@RequestParam(defaultValue="English") String lang
            , Model model) {

        List<TvShow> results = tvshowSvc.findAllTvShowsByLanguage(lang);
        model.addAttribute("tvshows", results);
        model.addAttribute("language", lang);

        return "tvshows";
    }
    
}
