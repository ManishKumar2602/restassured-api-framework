package com.api.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.api.pojo.Product;

public class ExcelUtil {

    public static Object[][] getExcelData(String filePath, String sheetName) {

        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][1];

            for (int i = 1; i < rows; i++) {
                Product product = new Product();

                Row row = sheet.getRow(i);

                product.setTitle(row.getCell(0).getStringCellValue());
                product.setPrice(row.getCell(1).getNumericCellValue());
                product.setDescription(row.getCell(2).getStringCellValue());
                product.setCategory(row.getCell(3).getStringCellValue());
                product.setImage(row.getCell(4).getStringCellValue());

                data[i - 1][0] = product;
            }

            workbook.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}