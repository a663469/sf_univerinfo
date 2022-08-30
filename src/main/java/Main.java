import univerinfo.StudentsFromFile;
import univerinfo.model.Student;
import univerinfo.UniversitiesFromFile;
import univerinfo.model.University;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Student> students = StudentsFromFile.getStudents("data/students.csv", "CSV");

        for (Student student : students) {
            System.out.println(student);
        }

        students = StudentsFromFile.getStudents("data/univerinfo.xlsx", "XLSX");

        for (Student student : students) {
            System.out.println(student);
        }

        List<University> universities = UniversitiesFromFile.getUniversities("data/universities.csv");

        for (University university : universities) {
            System.out.println(university);
        }

    }
}