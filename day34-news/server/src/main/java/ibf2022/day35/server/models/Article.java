package ibf2022.day35.server.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Article {

    private String author;
    private String title;
    private String description;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    } 

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("author", author)
            .add("title", title)
            .add("description", description)
            .build();
    }

    public static Article toArticle(JsonObject obj) {
        Article article = new Article();
        article.setAuthor(getValue("author", obj));
        article.setTitle(obj.getString("title"));
        article.setDescription(getValue("description", obj));
        return article;
    }

    private static String getValue(String fn, JsonObject o) {

        if (o.containsKey(fn) && !o.isNull(fn))
            return o.getString(fn);
        return "not value";
    }

    
}
