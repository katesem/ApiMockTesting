package com.example.core.mock;

import com.example.core.constants.APIConstants;
import com.example.core.constants.FilePaths;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServer {

    private static WireMockServer wireMockServer = new WireMockServer();
    private static final Logger LOG = LogManager.getLogger(MockServer.class);

    public static void startMock() {
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port()); //configure server locally
        LOG.info("WireMock server started on port: " + wireMockServer.port());
    }

    public static void configurePeopleEndpoint() {
        wireMockServer.stubFor(get(urlPathMatching(APIConstants.PEOPLE_MOCK_ENDPOINT))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader(APIConstants.CONTENT_TYPE, APIConstants.APPLICATION_JSON)
                        .withBodyFile(FilePaths.SW_PERSON)));
        LOG.info("Configured People Endpoint in WireMock");
    }

    public static void stopMockServer() {
        wireMockServer.stop();
        LOG.info("WireMock server stopped");
    }
}