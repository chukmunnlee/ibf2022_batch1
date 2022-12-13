package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayStoreAnalytics {

    public static final void main(String[] args) throws Exception {

        Reader r = new FileReader("googleplaystore.csv");
        BufferedReader br = new BufferedReader(r);

        List<App> apps = br.lines()
            // skip the header line
            .skip(1)
            // String -> String[]
            .map(l -> l.split(","))
            // .map(cols -> {
            // if (cols.length <= 14)
            // return cols;
            // cols[1] = "%s %s".formatted(cols[0], cols[1]);
            // String[] dest = new String[cols.length - 1];
            // System.arraycopy(cols, 1, dest, 0, dest.length);
            // return dest;
            // })
            .filter(cols -> cols.length <= 14)
            .filter(cols -> !cols[2].trim().toLowerCase().equals("nan"))
            // String[] -> App
            .map(cols -> {
                App app = new App();
                app.setName(cols[0]);
                app.setCategory(cols[1]);
                app.setRating(Float.parseFloat(cols[2]));
                return app;
            })
            .toList();

        br.close();
        r.close();

        //System.out.println(apps);

        Map<String, List<App>> groupByCategory = apps.stream()
            .collect(
                Collectors.groupingBy(app -> app.getCategory())
            );

        for (String c: groupByCategory.keySet()) {
            List<App> listOfApps = groupByCategory.get(c);
            System.out.printf("Categories: %s - %d\n", c, listOfApps.size());
        }

        for (App a: groupByCategory.get("EVENTS"))
            System.out.println(a);

    }
}
