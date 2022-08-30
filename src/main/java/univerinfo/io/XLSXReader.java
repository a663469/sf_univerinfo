package univerinfo.io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSXReader extends FileReaders{
    int columns = 100;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    Iterator<Row> rows;
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


    @Override
    public List<String> getNextLine() {
        List<String> retVal = new ArrayList<>();
        Row currentRow = rows.next();
        for(int i = 0; i < columns; i++) {
            try {
                retVal.add(currentRow.getCell(i).getStringCellValue());
            } catch (IllegalStateException e) {
                System.out.printf("%s ", currentRow.getCell(i).getNumericCellValue());
            } catch (NullPointerException e) {
                this.columns = i;
            }
        }
        return retVal;
    }

    @Override
    public boolean hasNextLine() {
        return rows.hasNext();
    }
}
