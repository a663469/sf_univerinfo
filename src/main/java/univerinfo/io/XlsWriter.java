package univerinfo.io;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import univerinfo.model.Statistics;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class XlsWriter {
    public XlsWriter(List<Statistics> statistics, String fileName){
        File currDir = new File("data\\.");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + fileName;
        try {
            Workbook workbook = new HSSFWorkbook();


            //Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Statistics");
            sheet.setColumnWidth(0, 10000);
            sheet.setColumnWidth(1, 10000);
            sheet.setColumnWidth(2, 10000);
            sheet.setColumnWidth(3, 10000);
            sheet.setColumnWidth(4, 10000);

            Row header = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            HSSFFont font = ((HSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            headerStyle.setFont(font);

            Cell headerCell = header.createCell(0);
            headerCell.setCellValue("Профиль обучения");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(1);
            headerCell.setCellValue("Средний балл за экзамен");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(2);
            headerCell.setCellValue("Количество студентов");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(3);
            headerCell.setCellValue("Количество университетов");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(4);
            headerCell.setCellValue("Названия университетов");
            headerCell.setCellStyle(headerStyle);



            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            int count = 1;
            for(Statistics st : statistics)
            {
                Row row = sheet.createRow(count);
                Cell cell = row.createCell(0);
                cell.setCellValue(st.getMainProfile().toString());
                cell.setCellStyle(style);

                if(st.getAvgExamScore().isPresent()) {
                    cell = row.createCell(1);
                    cell.setCellValue(st.getAvgExamScore().getAsDouble());
                    cell.setCellStyle(style);
                }

                cell = row.createCell(2);
                cell.setCellValue(st.getNumberOfStudentsByProfile());
                cell.setCellStyle(style);

                cell = row.createCell(3);
                cell.setCellValue(st.getNumberOfUniversitiesByProfile());
                cell.setCellStyle(style);

                cell = row.createCell(4);
                cell.setCellValue(st.getUniversitiesName().toString());
                cell.setCellStyle(style);

                count++;
            }

            FileOutputStream file = new FileOutputStream(new File(fileLocation));
            workbook.write(file);
        } catch (Exception e) {
            System.out.println("XlsWriter: " + e);
        }
    }
}
