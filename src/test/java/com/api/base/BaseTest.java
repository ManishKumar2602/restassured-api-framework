package com.api.base;

import org.testng.annotations.BeforeClass;

import com.api.config.ConfigManager;

import io.restassured.RestAssured;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigManager.get("baseUrl");
    }
}
