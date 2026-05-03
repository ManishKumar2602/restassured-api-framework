package com.api.utils;

import java.util.Arrays;
import java.util.List;
import java.io.File;

import com.api.pojo.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static Object[][] getJsonData(String filePath) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Product> list = Arrays.asList(
                mapper.readValue(new File(filePath), Product[].class)
            );

            Object[][] data = new Object[list.size()][1];

            for (int i = 0; i < list.size(); i++) {
                data[i][0] = list.get(i);
            }

            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
