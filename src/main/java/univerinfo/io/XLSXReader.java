package univerinfo.io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class XLSXReader extends FileReaders{
    private static Logger log = LoggerFactory.getLogger(XLSXReader.class);
    private int columns = 100;
    private FileInputStream fis;
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private Iterator<Row> rows;
    private Row row;
    XLSXReader(String file, String sheetName) {
        try {
            this.fis = new FileInputStream(file);
            this.wb = new XSSFWorkbook(this.fis);
            this.sheet = this.wb.getSheet(sheetName);
            this.rows =  this.sheet.iterator();
            this.row = this.rows.next();
            log.info("Чтение данных с " + new File(file).getAbsolutePath() + " страница " + sheetName);
        } catch (Exception e) {
            log.error(e.toString());
            System.exit(0);
        }
    }

    String getCellString(int index) {
        String retVal = "Error!";
        try {
            retVal = this.row.getCell(index).getStringCellValue();
        } catch (IllegalStateException e) {
            log.error("XLSXReader.getCellString Ошибка формата: " + e);
        } catch (Exception e) {
            log.error("XLSXReader.getCellString: " + e);
        }
        return retVal;
    }

    double getCellDouble(int index) {
        double retVal = -1;
        try {
            retVal = this.row.getCell(index).getNumericCellValue();
        } catch (IllegalStateException e) {
            log.error("XLSXReader.getCellDouble Ошибка формата: " + e);
        } catch (Exception e) {
            log.error("XLSXReader.getCellDouble: " + e);
        }
        return retVal;
    }

    @Override
    float getCellFloat(int index) {
        return (float) getCellDouble(index);
    }

    @Override
    int getCellInt(int index) {
        return (int) getCellDouble(index);
    }

    @Override
    boolean hasNextLine() {
        return rows.hasNext();
    }

    @Override
    void nextLine() {
        this.row = this.rows.next();
    }
}
