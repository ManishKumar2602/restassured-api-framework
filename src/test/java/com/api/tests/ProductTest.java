package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.BaseTest;
import com.api.logger.Log;
import com.api.pojo.Product;
import com.api.services.ProductService;
import com.api.utils.*;

import io.restassured.response.Response;

@Listeners(RetryListener.class)
public class ProductTest extends BaseTest {

    ProductService service = new ProductService();

    @Test
    public void createProductTest() {

        Product product = new Product();
        product.setTitle("Final Framework Product");
        product.setPrice(100);

        Response res = service.createProduct(product);

        Log.logger.info(res.asString());

        Assert.assertEquals(res.getStatusCode(), 201);
    }
    
    @Test(dataProvider = "jsonData", dataProviderClass = TestData.class)
    public void createProduct_JSON(Product product) {

        Response res = service.createProduct(product);

        Log.logger.info(res.asString());

        Assert.assertEquals(res.getStatusCode(), 201);
    }
    
    @Test(dataProvider = "excelData", dataProviderClass = TestData.class)
    public void createProduct_Excel(Product product) {

        Response res = service.createProduct(product);

        Log.logger.info(res.asString());

        Assert.assertEquals(res.getStatusCode(), 201);
    }
}
