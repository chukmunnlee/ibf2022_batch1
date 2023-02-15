package ibf2022.paf.day28;

public class Constants {

	public static final String BGG = "bgg";
	public static final String COLLECTION_COMMENTS = "comments";
	public static final String FIELD_TEXT_SCORE = "textScore";

	public static final String NETFLIX = "netflix";
	public static final String COLLECTION_TVSHOWS = "tvshows";
	public static final String FIELD_LANGUAGE = "language";
	public static final String FIELD_UNDERSCORE_ID = "_id";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_URL = "url";
	public static final String FIELD_GENRES = "genres";
	public static final String FIELD_RUNTIME = "runtime";
	public static final String FIELD_TITLE = "title";
	public static final String FIELD_TOTAL = "total";
	public static final String FIELD_SHOWS = "shows";
	public static final String FIELD_AVG_RATING = "rating.average";
	public static final String FIELD_RATING = "rating";

	public static final String CONCAT_NAME_AND_RUNTIME = """
        $concat: [ "$name", " (", { $toString: "$runtime" }, ")"]        
	""";

}
