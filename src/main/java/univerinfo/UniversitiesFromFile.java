package univerinfo;

import univerinfo.io.CSVReader;
import univerinfo.io.XLSXReader;
import univerinfo.model.Student;
import univerinfo.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesFromFile {
//    public static List<University> getUniversities(String file) {
//        CSVReader st = new CSVReader(file);
//        List<University> universities = new ArrayList<>();
//        while (st.hasNextLine()) {
//            String words[] = st.getNextLine();
//            try {
//                universities.add(new University(
//                        words[0],
//                        words[1],
//                        words[2],
//                        Integer.parseInt(words[3]),
//                        words[4]));
//            } catch (Exception e) {
//                for(String word : words) {
//                    System.out.printf(word + " ");
//                }
//                System.out.println(e);
//            }
//        }
//        return universities;
//    }

    public static List<University> getUniversities(String file, String sheetName) {
        List<University> uversities = new ArrayList<>();
        XLSXReader uv = new XLSXReader(file, sheetName);
        if (uv.hasNextLine()) {
            uv.nextLine();
        }
        while (uv.hasNextLine()) {
            try {
                uversities.add(new University(
                        uv.getCellString(0),
                        uv.getCellString(1),
                        uv.getCellString(2),
                        uv.getCellInt(3),
                        uv.getCellString(4)
                ));
                uv.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return uversities;
    }
}
