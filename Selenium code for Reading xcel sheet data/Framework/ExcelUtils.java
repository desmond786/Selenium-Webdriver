package Framework;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    // Load the Excel file and sheet
    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get the data from the specified cell
    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }

    // Get the number of rows in the sheet
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get the number of columns in the sheet
    public static int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }
}

