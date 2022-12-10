package com.jkmcllc.pairaws;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppUnmapTest {
  @Test
  public void successfulResponse() {
    App app = new App();
    String bodyString = "{\n" +
            "  \"accounts\": [\n" +
            "    {\n" +
            "      \"accountId\": \"JKM0001\", \n"+
            "      \"positions\": [ \n"+
            "        {\"symbol\": \"MSFT  160115P00080000\", \"price\": \"28.70\", \"qty\": -4, " +
            "          \"optionConfig\": {\"optionRootSymbol\": \"MSFT\", \"optionType\": \"P\", \"strike\": \"80.00\", \"expiry\": \"2016-01-15 16:00\"} " +
            "        }, \n" +
            "        {\"symbol\": \"MSFT  160115P00082000\", \"price\": \"30.19\", \"qty\": 4, " +
            "          \"optionConfig\": {\"optionRootSymbol\": \"MSFT\", \"optionType\": \"P\", \"strike\": \"82.00\", \"expiry\": \"2016-01-15 16:00\"} " +
            "        } \n" +
            "      ] \n"+
            "    },\n" +
            "    {\n" +
            "      \"accountId\": \"JKM0002\", \n"+
            "      \"positions\": [ \n"+
            "        {\"symbol\": \"MSFT  160115P00080000\", \"price\": \"28.70\", \"qty\": -4, " +
            "          \"optionConfig\": {\"optionRootSymbol\": \"MSFT\", \"optionType\": \"P\", \"strike\": \"80.00\", \"expiry\": \"2016-01-15 16:00\"} " +
            "        }, \n" +
            "        {\"symbol\": \"MSFT  160115P00082000\", \"price\": \"30.19\", \"qty\": 4, " +
            "          \"optionConfig\": {\"optionRootSymbol\": \"MSFT\", \"optionType\": \"P\", \"strike\": \"82.00\", \"expiry\": \"2016-01-15 16:00\"} " +
            "        } \n" +
            "      ] \n"+
            "    }\n" +
            "  ], \n" +
            "  \"optionRoots\": {\n" +
            "      \"MSFT\": {\"optionRootSymbol\": \"MSFT\", \"exerciseStyle\": \"A\", \"underlyerType\": \"S\" , \"multiplier\": \"100.00\",  " +
            "      \"deliverables\": { \n"+
            "        \"deliverableList\": [ \n"+
            "          {\"symbol\": \"MSFT\", \"deliverableType\": \"S\", \"qty\": \"100\" , \"price\": \"60.40\" } " +
            "        ] \n"+
            "      } \n"+
            "    } \n"+
            "  } \n" +
            "}";
    APIGatewayProxyRequestEvent proxyEvent = new APIGatewayProxyRequestEvent();
    proxyEvent.setBody(bodyString);
    proxyEvent.setHttpMethod("POST");
    APIGatewayProxyResponseEvent result = app.handleRequestUnmapped(proxyEvent, null);
    assertEquals(result.getStatusCode().intValue(), 200);
    assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    String content = result.getBody();
    assertNotNull(content);
    // assertTrue(content.contains("SPY"));
  }

  @Test
  public void testCoveredCall() {
    App app = new App();
    String bodyString = "{\n" +
            "    \"accounts\": [\n" +
            "        {\n" +
            "            \"positions\": [\n" +
            "                {\n" +
            "                    \"symbol\": \"CSCO\",\n" +
            "                    \"description\": \"Cisco stock\",\n" +
            "                    \"qty\": \"675\",\n" +
            "                    \"price\": \"48.08\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"orders\": [\n" +
            "                {\n" +
            "                    \"orderLegs\": [\n" +
            "                        {\n" +
            "                            \"symbol\": \"CSCO  230116C00050000\",\n" +
            "                            \"description\": \"\",\n" +
            "                            \"qty\": \"-3\",\n" +
            "                            \"price\": \"1.56\",\n" +
            "                            \"optionConfig\": {\n" +
            "                                \"optionRootSymbol\": \"CSCO\",\n" +
            "                                \"optionType\": \"C\",\n" +
            "                                \"strike\": \"50.00\",\n" +
            "                                \"expiry\": \"2023-01-16 16:00\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"orderId\": \"OrderA\",\n" +
            "                    \"orderDescription\": \"Sell to open 3 CSCO 50 call @ LM 2.31\",\n" +
            "                    \"orderMaintenanceCost\": \"-231.00\",\n" +
            "                    \"orderInitialCost\": \"-231.00\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"accountId\": \"Brian-Scenario1\",\n" +
            "            \"customProperties\": {},\n" +
            "            \"strategyGroupName\": \"core\",\n" +
            "            \"responseDetailLevel\": \"VERBOSE\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"optionRoots\": {\n" +
            "        \"CSCO\": {\n" +
            "            \"optionRootSymbol\": \"CSCO\",\n" +
            "            \"exerciseStyle\": \"A\",\n" +
            "            \"underlyerType\": \"S\",\n" +
            "            \"deliverables\": {\n" +
            "                \"deliverableList\": [\n" +
            "                    {\n" +
            "                        \"symbol\": \"CSCO\",\n" +
            "                        \"qty\": \"100\",\n" +
            "                        \"price\": \"40.08\",\n" +
            "                        \"maintenancePct\": \"0.25\",\n" +
            "                        \"deliverableType\": \"S\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"multiplier\": 100\n" +
            "        }\n" +
            "    }\n" +
            "}";
    APIGatewayProxyRequestEvent proxyEvent = new APIGatewayProxyRequestEvent();
    proxyEvent.setBody(bodyString);
    proxyEvent.setHttpMethod("POST");
    APIGatewayProxyResponseEvent result = app.handleRequestUnmapped(proxyEvent, null);
    assertEquals(result.getStatusCode().intValue(), 200);
    assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    String content = result.getBody();
    assertNotNull(content);
  }

}
