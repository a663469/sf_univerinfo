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
            this.row = this.rows.next();
        } catch (Exception e) {
            System.out.println("XLSXReader: " + e);
        }
    }

    public String getCellString(int index) {
        String retVal = "Error!";
        try {
            retVal = this.row.getCell(index).getStringCellValue();
        } catch (IllegalStateException e) {
            System.out.println("XLSXReader.getCellString Ошибка формата: " + e);
        } catch (Exception e) {
            System.out.println("XLSXReader.getCellString: " + e);
        }
        return retVal;
    }

    public double getCellDouble(int index) {
        double retVal = -1;
        try {
            retVal = this.row.getCell(index).getNumericCellValue();
        } catch (IllegalStateException e) {
            System.out.println("XLSXReader.getCellDouble Ошибка формата: " + e);
        } catch (Exception e) {
            System.out.println("XLSXReader.getCellDouble: " + e);
        }
        return retVal;
    }

    @Override
    public float getCellFloat(int index) {
        return (float) getCellDouble(index);
    }

    @Override
    public int getCellInt(int index) {
        return (int) getCellDouble(index);
    }

    @Override
    public boolean hasNextLine() {
        return rows.hasNext();
    }

    @Override
    public void nextLine() {
        this.row = this.rows.next();
    }
}
