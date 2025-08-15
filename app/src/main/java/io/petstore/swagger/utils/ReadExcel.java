package io.petstore.swagger.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

    public static Sheet getDataFromExcel(String filePath, String sheetName) {
        Sheet excelSheet = null;
        try {
            InputStream excelFile = new FileInputStream(filePath);
            Workbook excelBook = WorkbookFactory.create(excelFile);
            excelSheet = excelBook.getSheet(sheetName);

        } catch (Exception e) {
            Logger.error(ReadExcel.class, e.getMessage());

        }
        return excelSheet;
    }

    public static String getValueFromExcelCell(Row rowFile, Integer fileColumn) {
        try {
            if (rowFile == null || rowFile.getCell(fileColumn) == null) {

                return "";
            }
            String value = rowFile.getCell(fileColumn).getStringCellValue();

            return value != null ? value.trim() : "";
        } catch (Exception e) {
            return "";
        }
    }

}
