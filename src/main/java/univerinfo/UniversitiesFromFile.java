package univerinfo;

import univerinfo.io.CSVReader;
import univerinfo.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesFromFile {
    public static List<University> getUniversities(String file) {
        CSVReader st = new CSVReader(file);
        List<University> universities = new ArrayList<>();
        while (st.hasNextLine()) {
            String words[] = st.getNextLine();
            try {
                universities.add(new University(
                        words[0],
                        words[1],
                        words[2],
                        Integer.parseInt(words[3]),
                        words[4]));
            } catch (Exception e) {
                for(String word : words) {
                    System.out.printf(word + " ");
                }
                System.out.println(e);
            }
        }
        return universities;
    }
}
