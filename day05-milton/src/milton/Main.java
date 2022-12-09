package milton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        System.out.printf("Processing %s\n", fileName);

        // Open the file, read the first 100 lines print out each line
        // Close the file when done
        // If the file is less than 100 lines, close when done
        String line;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        Integer totalWords = 0;
        Map<String, Integer> wordMap = new HashMap<>();

        for (Integer i = 1; i <= 100; i++) {
            line = br.readLine();
            if (null == line)
                break;
            //System.out.printf("%d: %s\n", i, line.toUpperCase());
            String[] words = line.trim().split(" ");
            totalWords += words.length;
            for (String w: words) {
                Integer v = wordMap.getOrDefault(w, 0);
                v++;
                wordMap.put(w, v);
                // if (wordMap.containsKey(w)) {
                //     Integer v = wordMap.get(w) + 1;
                //     wordMap.put(w, v);
                // } else
                //     wordMap.put(w, 1);
            }
        }

        br.close();
        fr.close();

        Set<String> uniqueWords = wordMap.keySet();

        // for (String w: uniqueWords)
        //     System.out.printf("> %s: %d\n", w, wordMap.get(w));

        System.out.printf("The number of words in first 100 lines: %d\n"
                , totalWords);
        System.out.printf("Number of unque words: %d\n", uniqueWords.size());

    }

}