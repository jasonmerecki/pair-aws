package com.jkmcllc.pairaws;

import com.jkmcllc.aupair01.pairing.AccountPairingRequest;
import com.jkmcllc.aupair01.pairing.AccountPairingRequest.AccountPairingRequestBuilder;
import com.jkmcllc.aupair01.pairing.AccountPairingResponse;
import com.jkmcllc.aupair01.pairing.impl.PairingService;
import com.jkmcllc.aupair01.structure.DeliverableType;
import com.jkmcllc.aupair01.structure.ExerciseStyle;
import com.jkmcllc.aupair01.structure.OptionType;
import com.jkmcllc.aupair01.structure.UnderlyerType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PairingRequestOrderBuilderDavid {
    private final PairingService pairingService = PairingService.getInstance();
    @Test 
    public void buildDavidScenario1Test() {
        AccountPairingRequest pairingRequest = buildDavidScenario1(false);
        System.out.println(pairingRequest);
        assertNotNull(pairingRequest);
    }

    @Test
    public void executeDavidScenario1Test() {
        AccountPairingRequest pairingRequest = buildDavidScenario1(false);
        AccountPairingResponse accountPairingResponse = pairingService.processAccountRequest(pairingRequest);
        assertNotNull(accountPairingResponse);
    }
    
    public static AccountPairingRequest buildDavidScenario1(boolean requestAllStrategyLists) {
        AccountPairingRequestBuilder builder = AccountPairingRequest.newBuilder();

        // Build XPY root, first deliverables then root information
        builder.setDeliverableSymbol("XPY").setDeliverableQty("100").setDeliverablePrice("410.00").setDeliverableType(DeliverableType.S).addDeliverable();
        builder.setOptionRootSymbol("XPY").setOptionRootExerciseStyle(ExerciseStyle.A)
            .setOptionRootUnderlyerType(UnderlyerType.S).setOptionRootMultiplier("100.00").addOptionRoot();

        builder.setPositionSymbol("XPY 220612P305").setPositionOptionRoot("XPY").setPositionQty(-42)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("305").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("1.57").addPosition();
        builder.setPositionSymbol("XPY 220612P295").setPositionOptionRoot("XPY").setPositionQty(-37)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("295").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("3.6").addPosition();
        builder.setPositionSymbol("XPY 220612P282").setPositionOptionRoot("XPY").setPositionQty(-2)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("282").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220612C314").setPositionOptionRoot("XPY").setPositionQty(-58)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("314").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220612C322").setPositionOptionRoot("XPY").setPositionQty(-75)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("322").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220612C330").setPositionOptionRoot("XPY").setPositionQty(-70)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("330").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("1.19").addPosition();
        builder.setPositionSymbol("XPY 220612C338").setPositionOptionRoot("XPY").setPositionQty(-70)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("338").setPositionOptionExpiry("2022-06-12 16:00").setPositionPrice("0.25").addPosition();
        builder.setPositionSymbol("XPY 220619P305").setPositionOptionRoot("XPY").setPositionQty(42)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("305").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220619P295").setPositionOptionRoot("XPY").setPositionQty(37)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("295").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220619P282").setPositionOptionRoot("XPY").setPositionQty(2)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("282").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("2").addPosition();
        builder.setPositionSymbol("XPY 220619C314").setPositionOptionRoot("XPY").setPositionQty(58)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("314").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("2.88").addPosition();
        builder.setPositionSymbol("XPY 220619C322").setPositionOptionRoot("XPY").setPositionQty(75)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("322").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("0.64").addPosition();
        builder.setPositionSymbol("XPY 220619C330").setPositionOptionRoot("XPY").setPositionQty(70)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("330").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220619C338").setPositionOptionRoot("XPY").setPositionQty(70)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("338").setPositionOptionExpiry("2022-06-19 16:00").setPositionPrice("1.3").addPosition();
        builder.setPositionSymbol("XPY 220626P310").setPositionOptionRoot("XPY").setPositionQty(-110)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("310").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("3.75").addPosition();
        builder.setPositionSymbol("XPY 220626P298").setPositionOptionRoot("XPY").setPositionQty(-115)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("298").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("1.72").addPosition();
        builder.setPositionSymbol("XPY 220626P290").setPositionOptionRoot("XPY").setPositionQty(-85)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("290").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("3.99").addPosition();
        builder.setPositionSymbol("XPY 220626P279").setPositionOptionRoot("XPY").setPositionQty(-130)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("279").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("2.32").addPosition();
        builder.setPositionSymbol("XPY 220626P276").setPositionOptionRoot("XPY").setPositionQty(185)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("276").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("1.83").addPosition();
        builder.setPositionSymbol("XPY 220626P275").setPositionOptionRoot("XPY").setPositionQty(-185)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("275").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("1.71").addPosition();
        builder.setPositionSymbol("XPY 220626C318").setPositionOptionRoot("XPY").setPositionQty(-145)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("318").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("2.17").addPosition();
        builder.setPositionSymbol("XPY 220626C327").setPositionOptionRoot("XPY").setPositionQty(-160)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("327").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("2.46").addPosition();
        builder.setPositionSymbol("XPY 220626C335").setPositionOptionRoot("XPY").setPositionQty(-165)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("335").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("0.81").addPosition();
        builder.setPositionSymbol("XPY 220703P310").setPositionOptionRoot("XPY").setPositionQty(110)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("310").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("4.06").addPosition();
        builder.setPositionSymbol("XPY 220703P298").setPositionOptionRoot("XPY").setPositionQty(115)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("298").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("1.95").addPosition();
        builder.setPositionSymbol("XPY 220703P290").setPositionOptionRoot("XPY").setPositionQty(85)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("290").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("4.34").addPosition();
        builder.setPositionSymbol("XPY 220703P279").setPositionOptionRoot("XPY").setPositionQty(130)
                .setPositionOptionType(OptionType.P).setPositionOptionStrike("279").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("2.69").addPosition();
        builder.setPositionSymbol("XPY 220703C318").setPositionOptionRoot("XPY").setPositionQty(145)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("318").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("2.4").addPosition();
        builder.setPositionSymbol("XPY 220703C327").setPositionOptionRoot("XPY").setPositionQty(160)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("327").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("2.69").addPosition();
        builder.setPositionSymbol("XPY 220703C335").setPositionOptionRoot("XPY").setPositionQty(165)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("335").setPositionOptionExpiry("2022-07-03 16:00").setPositionPrice("0.93").addPosition();


        // Jason's modifications, adding one more short position and more stock
        builder.setPositionSymbol("XPY").setPositionQty(550).setPositionPrice("410.00").addPosition();
        builder.setPositionSymbol("XPY 220626C332").setPositionOptionRoot("XPY").setPositionQty(-2)
                .setPositionOptionType(OptionType.C).setPositionOptionStrike("332").setPositionOptionExpiry("2022-06-26 16:00").setPositionPrice("2.46").addPosition();

        builder.setRequestAllStrategyLists(requestAllStrategyLists);
        AccountPairingRequest pairingRequest = builder.build("David-Scenario1");
        return pairingRequest;
        
    }

}
