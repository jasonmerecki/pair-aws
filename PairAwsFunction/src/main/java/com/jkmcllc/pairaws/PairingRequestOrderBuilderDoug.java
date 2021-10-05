package com.jkmcllc.pairaws;

import com.jkmcllc.aupair01.pairing.AccountPairingRequest;
import com.jkmcllc.aupair01.pairing.AccountPairingRequest.AccountPairingRequestBuilder;
import com.jkmcllc.aupair01.structure.DeliverableType;
import com.jkmcllc.aupair01.structure.ExerciseStyle;
import com.jkmcllc.aupair01.structure.OptionType;
import com.jkmcllc.aupair01.structure.UnderlyerType;

public class PairingRequestOrderBuilderDoug {
    
    public static AccountPairingRequest buildDougScenario1(boolean requestAllStrategyLists) {
        AccountPairingRequestBuilder builder = AccountPairingRequest.newBuilder();

        /*
        Apr6, 2020 (positions)
        BTO 1 May15 SPY 240P
        STO 2 Apr24 SPY 245P
        BTO 1 May15 SPY 238P

        Apr 7, 2020 (order)
        BTO 1 May08 SPY 222P
        STO 1 May08 SPY 227P
        STO 1 May08 SPY 295C
        BTO 1 May08 SPY 300C
         */

        // Build SPY root, first deliverables then root information
        builder.setDeliverableSymbol("SPY").setDeliverableQty("100").setDeliverablePrice("406.59").setDeliverableType(DeliverableType.S).addDeliverable();
        builder.setOptionRootSymbol("SPY").setOptionRootExerciseStyle(ExerciseStyle.A)
            .setOptionRootUnderlyerType(UnderlyerType.I).setOptionRootMultiplier("100.00").addOptionRoot();
        
        // SPY holdings, 3 option symbols
        builder.setPositionSymbol("SPY   200515P00240000").setPositionOptionRoot("SPY").setPositionQty(1)
            .setPositionOptionType(OptionType.P).setPositionOptionStrike("240.00").setPositionOptionExpiry("2020-05-15 16:00").setPositionPrice("00.01").addPosition();
        builder.setPositionSymbol("SPY   200424P00245000").setPositionOptionRoot("SPY").setPositionQty(-2)
            .setPositionOptionType(OptionType.P).setPositionOptionStrike("245.00").setPositionOptionExpiry("2020-04-24 16:00").setPositionPrice("00.01").addPosition();
        builder.setPositionSymbol("SPY   200515P00238000").setPositionOptionRoot("SPY").setPositionQty(1)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("238.00").setPositionOptionExpiry("2020-05-15 16:00").setPositionPrice("00.01").addPosition();


        // Order is to-open
        builder.setOrderLegSymbol("SPY   200508P00222000").setOrderLegOptionRoot("SPY").setOrderLegQty(1)
            .setOrderLegOptionType(OptionType.P).setOrderLegOptionStrike("222.00").setOrderLegOptionExpiry("2020-05-08 16:00").setOrderLegPrice("00.01")
            .addOrderLeg();
        builder.setOrderLegSymbol("SPY   200508P00227000").setOrderLegOptionRoot("SPY").setOrderLegQty(-1)
            .setOrderLegOptionType(OptionType.P).setOrderLegOptionStrike("227.00").setOrderLegOptionExpiry("2020-05-08 16:00").setOrderLegPrice("00.01")
            .addOrderLeg();
        builder.setOrderLegSymbol("SPY   200508C00295000").setOrderLegOptionRoot("SPY").setOrderLegQty(-1)
                .setOrderLegOptionType(OptionType.C).setOrderLegOptionStrike("295.00").setOrderLegOptionExpiry("2020-05-08 16:00").setOrderLegPrice("111.00")
                .addOrderLeg();
        builder.setOrderLegSymbol("SPY   200508C00300000").setOrderLegOptionRoot("SPY").setOrderLegQty(1)
                .setOrderLegOptionType(OptionType.C).setOrderLegOptionStrike("300.00").setOrderLegOptionExpiry("2020-05-08 16:00").setOrderLegPrice("111.00")
                .addOrderLeg();
        builder.setOrderId("OrderA").setOrderDescription("Sell to open 1 SPY Iron Condor spread @ LM 2.00")
            .setOrderMaintenanceCost("-200.00").setOrderInitialCost("-200.00")
            .addOrder();
        
        builder.setRequestAllStrategyLists(requestAllStrategyLists);
        AccountPairingRequest pairingRequest = builder.build("Doug-Scenario1");
        return pairingRequest;
        
    }

}
