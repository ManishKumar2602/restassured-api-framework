package com.api.utils;

import com.api.config.ConfigManager;
import static io.restassured.RestAssured.*;

public class AuthUtil {

    private static String token;

    public static String getToken() {

        if (token == null) {
            token = given()
                    .header("Content-Type", "application/json")
                    .body("{\"username\":\"" + ConfigManager.get("username") +
                          "\",\"password\":\"" + ConfigManager.get("password") + "\"}")
                    .post("/auth/login")
                    .jsonPath().getString("token");
        }

        return token;
    }
}
