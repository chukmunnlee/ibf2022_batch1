package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayStoreAnalyticsPOutput {

    public static final void main(String[] args) throws Exception {

        Reader r = new FileReader("googleplaystore.csv");
        BufferedReader br = new BufferedReader(r);

        Writer w = new FileWriter("app_names.txt");
        BufferedWriter bw = new BufferedWriter(w);

        br.lines()
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
            .forEach(app -> {
                try { 
                    bw.write("%s\n".formatted(app.getName())); 
                } catch (Exception ex) { }
            });

        br.close();
        r.close();

        bw.flush();
        w.flush();
        bw.close();
        w.close();
    }
}
