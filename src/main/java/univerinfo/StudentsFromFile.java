package univerinfo;

import univerinfo.io.CSVReader;
import univerinfo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsFromFile {
    public static List<Student> getStudents(String file) {
        CSVReader st = new CSVReader(file); //"data/students.csv"
        List<Student> students = new ArrayList<>();
        while (st.hasNextLine()) {
            String words[] = st.getNextLine();
            String universityId;
            String fullName;
            int currentCourseNumber;
            float avgExamScore;
            try {
                universityId = words[0];
                fullName = words[1];
                currentCourseNumber = Integer.parseInt(words[2]);
                avgExamScore = Float.parseFloat(words[3].replace(",", "."));
                students.add(new Student(universityId, fullName, currentCourseNumber, avgExamScore));
            } catch (Exception e) {
                for(String word : words) {
                    System.out.printf(word + " ");
                }
                System.out.println(e);
            }
        }
        return students;
    }
}
