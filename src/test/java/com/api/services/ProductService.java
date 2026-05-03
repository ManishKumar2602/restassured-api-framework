package com.api.services;

import com.api.pojo.Product;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class ProductService {

    public Response createProduct(Product product) {
        return given()
                .header("Content-Type", "application/json")
                .body(product)
            .post("/products");
    }
}