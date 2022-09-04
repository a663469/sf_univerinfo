package univerinfo.io;

import univerinfo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsFromFile {
    public static List<Student> getStudents(String file) {
        return getListStudents(new CSVReader(file));
    }

    public static List<Student> getStudents(String file, String sheetName) {
        return getListStudents(new XLSXReader(file, sheetName));
    }

    private static List<Student> getListStudents(FileReaders st) {
        List<Student> students = new ArrayList<>();
        if (st.hasNextLine()) {
            st.nextLine();
        }
        while (st.hasNextLine()) {
            try {
                st.nextLine();
                students.add(new Student(
                        st.getCellString(0),
                        st.getCellString(1),
                        st.getCellInt(2),
                        st.getCellFloat(3)
                ));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return students;
    }
}