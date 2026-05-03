package com.api.utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "excelData")
    public static Object[][] excelData() {

        String path = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";
        return ExcelUtil.getExcelData(path, "Products");
    }

    @DataProvider(name = "jsonData")
    public static Object[][] jsonData() {

        String path = System.getProperty("user.dir") + "/src/test/resources/testdata.json";
        return JsonUtil.getJsonData(path);
    }
}
