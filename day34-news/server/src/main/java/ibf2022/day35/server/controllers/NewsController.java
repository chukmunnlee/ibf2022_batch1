package ibf2022.day35.server.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ibf2022.day35.server.models.Article;
import ibf2022.day35.server.services.NewsService;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsController {

    private Logger logger = Logger.getLogger(NewsController.class.getName());

    @Autowired 
    private NewsService newsSvc;

    @GetMapping(path="/news/{country}/{category}")
    @ResponseBody
    public ResponseEntity<String> getNews(@PathVariable String country,
            @PathVariable String category, 
            @RequestParam(defaultValue="10") int pageSize) {

        logger.log(Level.INFO, "country=%s, category=%s".formatted(country, category));

        List<Article> articles = newsSvc.getNews(country, category, pageSize);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        articles.stream()
                .forEach(v -> {
                    arrBuilder.add(v.toJson());
                });

        return ResponseEntity.ok(arrBuilder.build().toString());
    }
    
}
