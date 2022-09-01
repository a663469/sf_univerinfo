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
            List<String> words = st.getNextLine();
            try {
                students.add(new Student(
                        words.get(0),
                        words.get(1),
                        Integer.parseInt(words.get(2)),
                        Float.parseFloat(words.get(3).replace(",", "."))
                ));
            } catch (Exception e) {
                for (String word : words) {
                    System.out.printf(word + " ");
                }
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
                System.out.println(st.getCellString(0));
                //System.out.println(st.getCellString(1));
                //System.out.println((int)st.getCellDouble(2));
                //System.out.println((float)st.getCellDouble(3));
                System.out.println();

//                students.add(new Student(
//                        st.getCellString(0),
//                        st.getCellString(1),
//                        (int)st.getCellDouble(2),
//                        (float)st.getCellDouble(3)
//                ));
                st.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return students;
    }
}