package io.petstore.swagger.utils;

import io.petstore.swagger.models.DataPostPet;
import io.petstore.swagger.models.HaspDataPostPetExcel;
import io.petstore.swagger.models.buildPosPet.Category;
import io.petstore.swagger.models.buildPosPet.Tag;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FeedData {

    public void extractData(String filePath, String sheetName) {
        Sheet sheet = ReadExcel.getDataFromExcel(filePath, sheetName);

        switch (sheetName) {
            case "Post_Pet":
                extractDataPet(sheet);
                break;

            default:
                break;
        }
    }

    private void extractDataPet(Sheet sheet) {
        HaspDataPostPetExcel haspDataPostPetExcel = new HaspDataPostPetExcel();
        Row row = null;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            String scenario = getCellValue(row, 0);

            DataPostPet petData = new DataPostPet(
                    scenario,
                    Long.parseLong(getCellValue(row, 1)),
                    new Category(Long.parseLong(getCellValue(row, 2)),
                            getCellValue(row, 3)),
                    getCellValue(row, 4),
                    parsePhotoUrls(getCellValue(row, 5)),
                    List.of(new Tag(
                            Long.parseLong(getCellValue(row, 6)),
                            getCellValue(row, 7))),
                    getCellValue(row, 8));
            haspDataPostPetExcel.getDataPostPetExcel().put(scenario, petData);
        }
    }

    private String getCellValue(Row row, int index) {
        return ReadExcel.getValueFromExcelCell(row, index);
    }

    private List<String> parsePhotoUrls(String cellValue) {
        if (cellValue == null || cellValue.isBlank()) {
            return new ArrayList<>();
        }
        return Arrays.stream(cellValue.split(","))
                .map(String::trim)
                .toList();
    }
    
}
