package com.jkmcllc.pairaws;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppSqsTest {
    @Test
    public void successfulResponse() {
        AppSqs as = new AppSqs();
        SQSEvent event = new SQSEvent();
        SQSEvent.SQSMessage msg = new SQSEvent.SQSMessage();
        msg.setBody("{ \"AccountNumber\": \"JKM0001\", \"AccountBalance\": { \"TotalEquity\": \"0.00\", \"CashTradeBalance\": \"0.00\", \"MarginTradeBalance\": \"30922.39\", \"ShortTradeBalance\": \"0.00\", \"MoneyMarketTradeBalance\": \"0.00\", \"SMA\": \"0.00\" }, \"Positions\": [ { \"AccountType\": \"String!\", \"Symbol\": \"SPY   200515P00240000\", \"SettleQuantity\": \"10\", \"SecurityTypeCode\": \"O\", \"ClosingPrice\": \"0.01\", \"OptionSymbolRoot\": \"SPY\", \"OptionContractDate\": \"2020-05-15\", \"StrikePrice\": \"240.000\", \"CallPut\": \"P\" }, { \"AccountType\": \"String!\", \"Symbol\": \"SPY   200515P00230000\", \"SettleQuantity\": \"-7\", \"SecurityTypeCode\": \"O\", \"ClosingPrice\": \"0.01\", \"OptionSymbolRoot\": \"SPY\", \"OptionContractDate\": \"2020-05-15\", \"StrikePrice\": \"230.000\", \"CallPut\": \"P\" } ], \"OptionRoots\": [ { \"OptionRootSymbol\": \"SPY\", \"ExerciseStyle\": \"A\", \"UnderlyerType\": \"I\", \"Multiplier\": \"100\", \"Deliverables\": { \"SymbolDeliverables\": [ { \"symbol\": \"SPY\", \"qty\": \"100\", \"price\": \"406.59\", \"maintenancePct\": \"0.25\" } ], \"CashDeliverableValue\": \"0\" } } ] }");
        List<SQSEvent.SQSMessage> msgs = new ArrayList<>();
        msgs.add(msg);
        event.setRecords(msgs);
        as.handleRequest(event, null);
    }
}
