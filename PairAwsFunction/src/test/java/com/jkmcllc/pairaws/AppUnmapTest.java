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

}
