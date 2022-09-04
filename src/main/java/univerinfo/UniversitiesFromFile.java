package univerinfo;

import univerinfo.io.CSVReader;
import univerinfo.io.FileReaders;
import univerinfo.io.XLSXReader;
import univerinfo.model.Student;
import univerinfo.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesFromFile {
    public static List<University> getUniversities(String file) {
        return getListUniversities(new CSVReader(file));
    }

    public static List<University> getUniversities(String file, String sheetName) {
        return getListUniversities(new XLSXReader(file, sheetName));
    }

    private static List<University> getListUniversities(FileReaders uv) {
        List<University> uversities = new ArrayList<>();
        if (uv.hasNextLine()) {
            uv.nextLine();
        }
        while (uv.hasNextLine()) {
            try {
                uv.nextLine();
                uversities.add(new University(
                        uv.getCellString(0),
                        uv.getCellString(1),
                        uv.getCellString(2),
                        uv.getCellInt(3),
                        uv.getCellString(4)
                ));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return uversities;
    }
}
