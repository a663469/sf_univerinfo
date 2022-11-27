import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import univerinfo.comparator.StudentComparator;
import univerinfo.comparator.UniversityComparator;
import univerinfo.enums.StudentComparatorVariants;
import univerinfo.enums.UniversityComparatorVariants;
import univerinfo.io.StudentsFromFile;
import univerinfo.io.UniversitiesFromFile;
import univerinfo.io.XlsWriter;
import univerinfo.model.Student;
import univerinfo.model.University;
import univerinfo.util.*;

import java.util.List;

import static univerinfo.util.JsonUtil.*;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        log.info("Запуск программы!");

        List<Student>  students = StudentsFromFile.getStudents("data/universityInfo.xlsx", "Студенты");
//        students.stream().forEach(System.out::println);

        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorVariants.NAME);
//        students.stream().sorted(studentComparator).forEach(System.out::println);

        List<University> universities = UniversitiesFromFile.getUniversities("data/universityInfo.xlsx", "Университеты");
//        universities.stream().forEach(System.out::println);

        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorVariants.YEAR_OF_FOUNDATION);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);

        new XlsWriter(StatisticsByProfile.createStatistics(students, universities), "temp_stream.xls");

        log.info("Программа заверщена!");
    }
}
