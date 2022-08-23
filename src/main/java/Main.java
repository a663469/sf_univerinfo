import enums.StudyProfile;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Student> students = new ArrayList<>();
        students.add(new Student("123", "ABC", 2, 4));
        students.add(new Student("123", "ABC1", 3, 4));
        students.add(new Student("123", "ABC2", 3, 4));

        for (Student student : students) {
            System.out.println(student);
        }

        List<University> universities = new ArrayList<>();
        universities.add(new University("123", "Sasd2 asd", "as1df", 1990, StudyProfile.ECOLOGY));
        universities.add(new University("1234", "Sasd asd", "asdf2", 1990, StudyProfile.RADIO));
        universities.add(new University("1235", "Sa3sd asd", "asdf3", 1990, StudyProfile.INFOCOMMUNCATION));
        universities.add(new University("1236", "Sasd a4sd", "asdf4", 1990, StudyProfile.DESIGN));
        universities.add(new University("1237", "Sasd3 asd", "asdf5", 1990, StudyProfile.BIOTECHNICAL));
        universities.add(new University("1238", "Sasd 2asd", "asdf6", 1990, StudyProfile.COMPUTER_SCENCE));

        for (University university : universities) {
            System.out.println(university);
        }
    }
}