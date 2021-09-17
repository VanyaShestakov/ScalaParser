package Parser;

import java.io.*;
import java.util.*;

public class SourceReader {

    private static final String PATH = "helloWorld.txt";

    public static List<String> readSource() {
        List<String> sourceList = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(PATH))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                sourceList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sourceList;
    }
}
