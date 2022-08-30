import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.apache.batik.swing.gvt.Interactor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public ExcelReader(String file){
        try {
            //obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(new File(file));
            //creating workbook instance that refers to .xls file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object
            XSSFSheet sheet = wb.getSheet("Университеты");
            //evaluating cell type
            Iterator<Row> rows =  sheet.iterator();
            int i = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                System.out.println(currentRow.getCell(1).getStringCellValue());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ExcelReader(File file, String sheetName){
        try {
            int n = 100;
            //obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(file);
            //creating workbook instance that refers to .xls file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object
            XSSFSheet sheet = wb.getSheet(sheetName);
            //evaluating cell type
            Iterator<Row> rows =  sheet.iterator();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                for(int i = 0; i < n; i++) {
                    try {
                        System.out.printf("%s ", currentRow.getCell(i).getStringCellValue());
                    } catch (IllegalStateException e) {
                        System.out.printf("%s ", currentRow.getCell(i).getNumericCellValue());
                    } catch (NullPointerException e) {
                        n = i;
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<University> readUniversityData(File file, String sheetName){
        List<University> universities = new ArrayList<>();
        try {
            //obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(file);
            //creating workbook instance that refers to .xls file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object
            XSSFSheet sheet = wb.getSheet(sheetName);
            //evaluating cell type
            Iterator<Row> rows =  sheet.iterator();
            rows.next();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                try {
                    universities.add(new University(
                                    currentRow.getCell(0).getStringCellValue(),
                                    currentRow.getCell(1).getStringCellValue(),
                                    currentRow.getCell(2).getStringCellValue(),
                                    (int) currentRow.getCell(3).getNumericCellValue(),
                                    currentRow.getCell(4).getStringCellValue()
                            )
                    );
//                } catch (IllegalStateException e) {
//                    //
                } catch (Exception e) {
                    System.out.println("readUniversityData: ");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return universities;
    }

    public static List<Student> readStudentsData(File file, String sheetName){
        List<Student> students = new ArrayList<>();
        try {
            //obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(file);
            //creating workbook instance that refers to .xls file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object
            XSSFSheet sheet = wb.getSheet(sheetName);
            //evaluating cell type
            Iterator<Row> rows =  sheet.iterator();
            rows.next();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                try {
                    students.add(new Student(
                                    currentRow.getCell(0).getStringCellValue(),
                                    currentRow.getCell(1).getStringCellValue(),
                                    (int) currentRow.getCell(2).getNumericCellValue(),
                                    (float) currentRow.getCell(3).getNumericCellValue()
                            )
                    );
//                } catch (IllegalStateException e) {
//                    //
                } catch (Exception e) {
                    System.out.println("readStudentsData: ");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return students;
    }
}