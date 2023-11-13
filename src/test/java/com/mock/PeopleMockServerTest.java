package com.mock;

import com.example.core.mock.MockServer;
import com.example.core.testng.BaseMockTest;
import org.testng.annotations.Test;

import static com.example.core.apiRequests.StarWarsAPI.getPeopleByIDRequest;

public class PeopleMockServerTest extends BaseMockTest {

    @Test
    public void peopleMockTest() {
        String peopleID = "1";

        MockServer.configurePeopleEndpoint();
        getPeopleByIDRequest(peopleID);
    }
}