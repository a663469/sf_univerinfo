package univerinfo.io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSXReader extends FileReaders{
    private int columns = 100;
    private FileInputStream fis;
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private Iterator<Row> rows;
    private Row row;
    public XLSXReader(String file, String sheetName) {
        try {
            this.fis = new FileInputStream(file);
            this.wb = new XSSFWorkbook(this.fis);
            this.sheet = this.wb.getSheet(sheetName);
            this.rows =  this.sheet.iterator();
        } catch (Exception e) {
            System.out.println("XLSXReader: ");
            System.out.println(e);
        }
    }

    public String getCellString(int index) {
        String retVal = "Error Format!";
        try {
            retVal = this.row.getCell(index).getStringCellValue();
        } catch (IllegalStateException e) {
            System.out.println("XLSXReader. Ошибка формата: " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return retVal;
    }

    public double getCellDouble(int index) {
        double retVal = -1;
        try {
            retVal = this.row.getCell(index).getNumericCellValue();
        } catch (IllegalStateException e) {
            System.out.println("XLSXReader. Ошибка формата: " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return retVal;
    }

    @Override
    public List<String> getNextLine() {
        List<String> retVal = new ArrayList<>();
        Row currentRow = rows.next();
        for(int i = 0; i < columns; i++) {
            try {
                retVal.add(currentRow.getCell(i).getStringCellValue());
            } catch (IllegalStateException e) {
                System.out.printf("Error with %s \n", currentRow.getCell(i).getNumericCellValue());
            } catch (NullPointerException e) {
                this.columns = i;
            }
        }
        System.out.println("XLSXReader: ");
        for (String ret : retVal)
        {
            System.out.printf(ret + " ");
        }
        System.out.println();
        return retVal;
    }

    @Override
    public boolean hasNextLine() {
        return rows.hasNext();
    }

    @Override
    public void nextLine() {
        this.rows.next();
    }
}
