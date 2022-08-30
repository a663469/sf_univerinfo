import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");

        List<Student> students = new ArrayList<>();
        List<University> universities = new ArrayList<>();

        try {
            File file = new File ("data/universityInfo.xlsx");
            if (file == null) {
                System.out.println("Empty!");
            } else {
                universities = ExcelReader.readUniversityData(file, "Университеты");
                students = ExcelReader.readStudentsData(file, "Студенты");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(students);
        System.out.println(universities);
    }
}