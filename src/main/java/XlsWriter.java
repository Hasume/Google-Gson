import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal; // Добавлен импорт для BigDecimal
import java.util.List;

public class XlsWriter {
    public static void generateAndWriteXLSX(String filePath, List<Statistics> statisticsList) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Statistics");
            CreationHelper createHelper = workbook.getCreationHelper();

            // Стиль для заголовков
            CellStyle headerCellStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerCellStyle.setFont(headerFont);

            // Заголовки таблицы
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Study Profile", "Average Exam Score", "Student Count", "University Count", "University Names"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }

            // Заполнение данными
            int rowNum = 1;
            for (Statistics statistics : statisticsList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(statistics.getStudyProfile());
                row.createCell(1).setCellValue(BigDecimal.valueOf(statistics.getAvgExamScore()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                row.createCell(2).setCellValue(statistics.getStudentCount());
                row.createCell(3).setCellValue(statistics.getUniversityCount());
                Cell universityNamesCell = row.createCell(4);
                universityNamesCell.setCellValue(String.join(", ", statistics.getUniversityNames()));
            }

            // Запись в файл
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}