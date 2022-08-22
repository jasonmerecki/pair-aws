package com.jkmcllc.pairaws;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jkmcllc.aupair01.pairing.AccountPairingResponse;
import com.jkmcllc.aupair01.pairing.PairingResponse;
import com.jkmcllc.aupair01.structure.OptionConfig;
import com.jkmcllc.aupair01.structure.impl.PairingRequestImpl;
import com.jkmcllc.pairaws.pojo.AccountMarginRequest;
import com.jkmcllc.pairaws.service.LambdaPairingService;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final LambdaPairingService lambdaPairingService = LambdaPairingService.getInstance();
    private final Gson gsonInstance = new GsonBuilder().
        registerTypeAdapter(LocalDateTime.class, new OptionConfig.GsonLocalDateTime()).create();

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        return handleRequestMapped(input, context);
    }

    public APIGatewayProxyResponseEvent handleRequestMapped(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);
        try {
            String methodCheck = input.getHttpMethod();
            String output = "";
            if (! methodCheck.equalsIgnoreCase("POST")) {
                String ret = String.format("{\"message\": \"method '%s' not supported by PairAws\" }", methodCheck);
                output = ret;
            } else {
                String rawout = gsonInstance.toJson(input);
                // System.out.println(String.format("raw input 20211009-01: \n %s", rawout));
                String inputBodyRaw = input.getBody();
                AccountMarginRequest marginRequest = gsonInstance.fromJson(inputBodyRaw, AccountMarginRequest.class);
                AccountPairingResponse accountPairingResponse = lambdaPairingService.processAccountRequest(marginRequest);
                output = gsonInstance.toJson(accountPairingResponse);
            }
            return response
                    .withStatusCode(200)
                    .withBody(output);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            String exout = String.format("{\"message\": \"ruh-roh, an exception, %s: \n '%s' \" }", e.getMessage(), exceptionAsString);
            return response
                    .withBody(exout)
                    .withStatusCode(500);
        }
    }

    public APIGatewayProxyResponseEvent handleRequestUnmapped(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);
        PairingRequestImpl pairingRequest = null;
        try {
            String methodCheck = input.getHttpMethod();
            String output = "";
            if (! methodCheck.equalsIgnoreCase("POST")) {
                String ret = String.format("{\"message\": \"method '%s' not supported by PairUnmappedAws\" }", methodCheck);
                output = ret;
            } else {
                String rawout = gsonInstance.toJson(input);
                // System.out.println(String.format("raw input: \n %s", rawout));
                String inputBodyRaw = input.getBody();
                System.out.println(String.format("input body: \n %s", rawout));
                pairingRequest = gsonInstance.fromJson(inputBodyRaw, PairingRequestImpl.class);
                PairingResponse accountPairingResponse = lambdaPairingService.processRequest(pairingRequest);
                output = gsonInstance.toJson(accountPairingResponse);
                System.out.println(String.format("output body: \n %s", output));
            }
            return response
                    .withStatusCode(200)
                    .withBody(output);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            String exout = String.format("{\"message\": \"ruh-roh, an exception, %s: \n '%s' \" }", e.getMessage(), exceptionAsString);
            return response
                    .withBody(exout)
                    .withStatusCode(500);
        }
    }

}
