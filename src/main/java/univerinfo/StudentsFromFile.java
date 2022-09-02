package univerinfo;

import univerinfo.io.CSVReader;
import univerinfo.io.XLSXReader;
import univerinfo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsFromFile {
    public static List<Student> getStudents(String file) {
        List<Student> students = new ArrayList<>();
        CSVReader st = new CSVReader(file); //"data/students.csv"
        if (st.hasNextLine()) {
            st.nextLine();
        }
        while (st.hasNextLine()) {
            try {
                students.add(new Student(
                        st.getCellString(0),
                        st.getCellString(1),
                        st.getCellInt(2),
                        st.getCellFloat(3)
                ));
                st.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return students;
    }

    public static List<Student> getStudents(String file, String sheetName) {
        List<Student> students = new ArrayList<>();
        XLSXReader st = new XLSXReader(file, sheetName);
        if (st.hasNextLine()) {
            st.nextLine();
        }
        while (st.hasNextLine()) {
            try {
                students.add(new Student(
                        st.getCellString(0),
                        st.getCellString(1),
                        st.getCellInt(2),
                        st.getCellFloat(3)
                ));
                st.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return students;
    }
}