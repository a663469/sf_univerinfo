import univerinfo.comparator.StudentComparator;
import univerinfo.enums.StudentComparatorVariants;
import univerinfo.io.StudentsFromFile;
import univerinfo.model.Student;
import univerinfo.io.UniversitiesFromFile;
import univerinfo.model.University;
import univerinfo.utility.ComparatorUtily;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("Read from csv:");

        List<Student> students = StudentsFromFile.getStudents("data/students.csv");

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("Compare:");

        StudentComparator studentComparator = ComparatorUtily.getStudentComparator(StudentComparatorVariants.NAME);
        students.stream().sorted(studentComparator).forEach(System.out::println);


//        List<Student>  sts = StudentsFromFile.getStudents("data/universityInfo.xlsx", "Студенты");
//
//        for (Student student : sts) {
//            System.out.println(student);
//        }
//
//        List<University> universities = UniversitiesFromFile.getUniversities("data/universities.csv");
//
//        for (University university : universities) {
//            System.out.println(university);
//        }
//
//        universities = UniversitiesFromFile.getUniversities("data/universityInfo.xlsx", "Университеты");
//
//        for (University university : universities) {
//            System.out.println(university);
//        }



    }
}