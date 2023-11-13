package com.example.core.apiRequests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.example.core.constants.APIConstants.*;
import static io.restassured.RestAssured.given;

public class StarWarsAPI {
    private static final Logger LOG = LogManager.getLogger(StarWarsAPI.class);

    public static void getPeopleByIDRequest(String id){
        given()
                .pathParam(ID, id)
                .get(PEOPLE_ID_ENDPOINT);
        LOG.info("Sent request to " + PEOPLE_ID_ENDPOINT);
    }
}