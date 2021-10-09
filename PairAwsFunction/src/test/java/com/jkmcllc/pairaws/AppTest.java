package com.jkmcllc.pairaws;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest {
  @Test
  public void successfulResponse() {
    App app = new App();
    String bodyString = "{\n" +
            "  \"AccountNumber\": \"JKM0001\",\n" +
            "  \"AccountBalance\": {\n" +
            "    \"TotalEquity\": \"0.00\",\n" +
            "    \"CashTradeBalance\": \"0.00\",\n" +
            "    \"MarginTradeBalance\": \"30921.39\",\n" +
            "    \"ShortTradeBalance\": \"0.00\",\n" +
            "    \"MoneyMarketTradeBalance\": \"0.00\",\n" +
            "    \"SMA\": \"0.00\"\n" +
            "  },\n" +
            "  \"Positions\": [\n" +
            "    {\n" +
            "      \"AccountType\": \"String!\",\n" +
            "      \"Symbol\": \"SPY   200515P00240000\",\n" +
            "      \"SettleQuantity\": \"10\",\n" +
            "      \"SecurityTypeCode\": \"O\",\n" +
            "      \"ClosingPrice\": \"0.01\",\n" +
            "      \"OptionSymbolRoot\": \"SPY\",\n" +
            "      \"OptionContractDate\": \"2020-05-15\",\n" +
            "      \"StrikePrice\": \"240.000\",\n" +
            "      \"CallPut\": \"P\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"AccountType\": \"String!\",\n" +
            "      \"Symbol\": \"SPY   200515P00230000\",\n" +
            "      \"SettleQuantity\": \"-7\",\n" +
            "      \"SecurityTypeCode\": \"O\",\n" +
            "      \"ClosingPrice\": \"0.01\",\n" +
            "      \"OptionSymbolRoot\": \"SPY\",\n" +
            "      \"OptionContractDate\": \"2020-05-15\",\n" +
            "      \"StrikePrice\": \"230.000\",\n" +
            "      \"CallPut\": \"P\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"OptionRoots\": [\n" +
            "    {\n" +
            "      \"OptionRootSymbol\": \"SPY\",\n" +
            "      \"ExerciseStyle\": \"A\",\n" +
            "      \"UnderlyerType\": \"I\",\n" +
            "      \"Multiplier\": \"100\",\n" +
            "      \"Deliverables\": {\n" +
            "        \"SymbolDeliverables\": [\n" +
            "          {\n" +
            "            \"symbol\": \"SPY\",\n" +
            "            \"qty\": \"100\",\n" +
            "            \"price\": \"406.59\",\n" +
            "            \"maintenancePct\": \"0.25\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"CashDeliverableValue\": \"0\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    APIGatewayProxyRequestEvent proxyEvent = new APIGatewayProxyRequestEvent();
    proxyEvent.setBody(bodyString);
    proxyEvent.setHttpMethod("POST");
    APIGatewayProxyResponseEvent result = app.handleRequest(proxyEvent, null);
    assertEquals(result.getStatusCode().intValue(), 200);
    assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    String content = result.getBody();
    assertNotNull(content);
    // assertTrue(content.contains("\"message\""));
    // assertTrue(content.contains("\"hello "));
    // assertTrue(content.contains("\"location\""));
    assertTrue(content.contains("SPY"));
  }
}
