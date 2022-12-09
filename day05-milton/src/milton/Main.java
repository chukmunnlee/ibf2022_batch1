package milton;

import java.io.BufferedReader;
import java.io.FileReader;

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

        Integer i = 1;
        while (i <= 100) {
            line = br.readLine();
            if (null == line)
                break;
            System.out.printf("%d: %s\n", i, line.toUpperCase());
            i++;
        }

        br.close();
        fr.close();
    }

}