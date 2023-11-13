package com.example.core.testng;

import com.example.core.mock.MockServer;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.example.core.constants.APIConstants.BASE_URL;
import static io.restassured.RestAssured.given;

public abstract class BaseMockTest {

    @BeforeClass(alwaysRun = true)
    public void setupRestAssured() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = given()
                .relaxedHTTPSValidation();
    }


    @BeforeMethod(alwaysRun = true)
    public void startAndConfigureMockServer() {
        MockServer.startMock();
    }

    @AfterMethod(alwaysRun = true)
    public void stopMockServer() {
        MockServer.stopMockServer();
    }
}
