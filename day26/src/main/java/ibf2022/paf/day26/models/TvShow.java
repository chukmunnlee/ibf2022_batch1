package ibf2022.paf.day26.models;

import org.bson.Document;

import static ibf2022.paf.day26.Constants.*;

public class TvShow {

    private int id;
    private String name;
    private String url;
    private float rating;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    public static TvShow create(Document doc) {
        TvShow tvShow = new TvShow();
        tvShow.setId(doc.getInteger(FIELD_ID));
        tvShow.setName(doc.getString(FIELD_NAME));
        tvShow.setUrl(doc.getString(FIELD_URL));
        return tvShow;
    }

    public static TvShow createSummary(Document doc) {
        TvShow tvShow = new TvShow();
        tvShow.setId(doc.getInteger(FIELD_ID));
        tvShow.setName(doc.getString(FIELD_NAME));
		  Document d = (Document)doc.get(FIELD_RATING);
		  tvShow.setRating(d.getDouble(FIELD_AVERAGE).floatValue());
        return tvShow;
    }

}
