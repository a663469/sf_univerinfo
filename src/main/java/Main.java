import univerinfo.comparator.StudentComparator;
import univerinfo.comparator.UniversityComparator;
import univerinfo.enums.StudentComparatorVariants;
import univerinfo.enums.UniversityComparatorVariants;
import univerinfo.io.StudentsFromFile;
import univerinfo.io.UniversitiesFromFile;
import univerinfo.model.Student;
import univerinfo.model.University;
import univerinfo.utility.ComparatorUtility;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        System.out.println("Студенты:");

        System.out.println("Read from csv:");
        List<Student> students = StudentsFromFile.getStudents("data/students.csv");
        /*OR*/
//        System.out.println("Read from xlsx:");
//        List<Student>  students = StudentsFromFile.getStudents("data/universityInfo.xlsx", "Студенты");

        students.stream().forEach(System.out::println);

        System.out.println("Compare:");

        StudentComparator studentComparator = ComparatorUtility.getStudentComparator(StudentComparatorVariants.NAME);
        students.stream().sorted(studentComparator).forEach(System.out::println);


        /*************************************************************************************************************/
        System.out.println("Университеты:");

//        System.out.println("Read from csv:");
//        List<University> universities = UniversitiesFromFile.getUniversities("data/universities.csv");
        /*OR*/
        System.out.println("Read from xlsx:");
        List<University> universities = UniversitiesFromFile.getUniversities("data/universityInfo.xlsx", "Университеты");

        universities.stream().forEach(System.out::println);

        System.out.println("Compare:");
        UniversityComparator universityComparator = ComparatorUtility.getUniversityComparator(UniversityComparatorVariants.YEAR_OF_FOUNDATION);
        universities.stream().sorted(universityComparator).forEach(System.out::println);
    }
}