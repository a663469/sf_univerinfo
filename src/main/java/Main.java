import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import univerinfo.comparator.StudentComparator;
import univerinfo.comparator.UniversityComparator;
import univerinfo.enums.StudentComparatorVariants;
import univerinfo.enums.StudyProfile;
import univerinfo.enums.UniversityComparatorVariants;
import univerinfo.io.StudentsFromFile;
import univerinfo.io.UniversitiesFromFile;
import univerinfo.io.XlsWriter;
import univerinfo.model.Statistics;
import univerinfo.model.Student;
import univerinfo.model.University;
import univerinfo.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static univerinfo.util.JsonUtil.*;

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
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorVariants.NAME);
        students.stream().sorted(studentComparator).forEach(System.out::println);


        //Конвертируем объекты "студенты" в json формат
        String studentsJson = studentListToJson(students);
        System.out.println(studentsJson);
        // С json формат создаем объекты "студенты"
        List<Student> studentsFromJson = jsonToStudentList(studentsJson);
        // Сровнение количество объектов
        System.out.printf("Количество до и после преобрзазование совпадает? ");
        System.out.println(students.size() == studentsFromJson.size() ? "ДА!" : "НЕТ!");



//        7. С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
        students.forEach(student -> {
//        8. Там же внутри стрима выводить получающиеся JSON-строки.
            String studentJson = studentToJson(student);
//        9. Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
            System.out.println(studentJson);
//        10. Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
            Student studentFromJson = jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

        /*************************************************************************************************************/
        System.out.println("Университеты:");

//        System.out.println("Read from csv:");
//        List<University> universities = UniversitiesFromFile.getUniversities("data/universities.csv");
        /*OR*/
        System.out.println("Read from xlsx:");
        List<University> universities = UniversitiesFromFile.getUniversities("data/universityInfo.xlsx", "Университеты");

        universities.stream().forEach(System.out::println);

        System.out.println("Compare:");
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorVariants.YEAR_OF_FOUNDATION);
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        String universitiesJson = universityListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });


        new XlsWriter(StatisticsByProfile.getStatisticsList(students, universities), "temp.xls");

        new XlsWriter(StatisticsByProfile.createStatistics(students, universities), "temp_stream.xls");
//        System.out.println("************************************Test Java Stream API*********************************");
//
//        List<Statistics> sl = new ArrayList<>();
//
//        Set<StudyProfile> profiles = universities.stream()
//                .map(University::getMainProfile)
//                .collect(Collectors.toSet());
//        System.out.println(profiles);
//        profiles.forEach(profiles -> {
//            Statistics statistics = new Statistics();
//
//        });




    }
}
