package com.jkmcllc.pairaws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jkmcllc.aupair01.pairing.AccountPairingResponse;
import com.jkmcllc.aupair01.structure.OptionConfig;
import com.jkmcllc.pairaws.pojo.AccountMarginRequest;
import com.jkmcllc.pairaws.service.LambdaPairingService;

import java.time.LocalDateTime;

public class AppSqs implements RequestHandler<SQSEvent, Void> {
    private final LambdaPairingService pairingService = LambdaPairingService.getInstance();
    private final Gson gsonInstance = new GsonBuilder().
            registerTypeAdapter(LocalDateTime.class, new OptionConfig.GsonLocalDateTime()).create();

    @Override
    public Void handleRequest(SQSEvent event, Context context)
    {
        for(SQSEvent.SQSMessage msg : event.getRecords()){
            System.out.println(new String("AppSqs received: " + msg.getBody()));
            String inputBodyRaw = msg.getBody();
            AccountMarginRequest marginRequest = gsonInstance.fromJson(inputBodyRaw, AccountMarginRequest.class);
            AccountPairingResponse accountPairingResponse = pairingService.processAccountRequest(marginRequest);
            String output = gsonInstance.toJson(accountPairingResponse);
            System.out.println(new String("AppSqs response: " + output));
        }
        return null;
    }
}
