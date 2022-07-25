package com.jkmcllc.pairaws.service;

import com.google.gson.Gson;
import com.jkmcllc.aupair01.pairing.AccountPairingRequest;
import com.jkmcllc.aupair01.structure.*;
import com.jkmcllc.pairaws.pojo.AccountMarginRequest;
import com.jkmcllc.pairaws.pojo.OptionRoot;
import com.jkmcllc.pairaws.pojo.Position;
import com.jkmcllc.pairaws.pojo.SymbolDeliverable;

import java.util.Objects;

public class LambdaPairingBuilder {
    private static final Gson gsonInstance = new Gson();
    public static AccountPairingRequest buildAccountPairingRequest(AccountMarginRequest marginRequest) {
        AccountPairingRequest.AccountPairingRequestBuilder builder = AccountPairingRequest.newBuilder();

        // Build option roots, first deliverables then root information
        for (OptionRoot root : (marginRequest.getOptionRoots()) ) {
            if (root.getDeliverables() != null && root.getDeliverables().getSymbolDeliverables() != null) {
                for (SymbolDeliverable sd : root.getDeliverables().getSymbolDeliverables()) {
                    builder.setDeliverableSymbol(sd.getSymbol()).setDeliverableQty(sd.getQty()).setDeliverablePrice(sd.getPrice()).setDeliverableType(DeliverableType.S).addDeliverable();
                }
            }
            builder.setOptionRootSymbol(root.getOptionRootSymbol()).setOptionRootExerciseStyle(ExerciseStyle.valueOf(root.getExerciseStyle()))
                    .setOptionRootUnderlyerType(UnderlyerType.valueOf(root.getUnderlyerType())).setOptionRootMultiplier(root.getMultiplier()).addOptionRoot();
        }

        // Build positions
        for (Position pos : (marginRequest.getPositions()) ) {
            Integer posInt = Integer.parseInt(pos.getSettleQuantity());
            if (Objects.equals(pos.getSecurityTypeCode(), "S")) {
                builder.setPositionSymbol(pos.getSymbol()).setPositionQty(posInt).setPositionPrice(pos.getClosingPrice()).addPosition();
            } else if (Objects.equals(pos.getSecurityTypeCode(), "O")) {
                String expiry = pos.getOptionContractDate();
                expiry = (expiry.length() <= 10) ? expiry + " 00:00" : expiry;
                builder.setPositionSymbol(pos.getSymbol()).setPositionOptionRoot(pos.getOptionSymbolRoot()).setPositionQty(posInt)
                        .setPositionOptionType(OptionType.valueOf(pos.getCallPut())).setPositionOptionStrike(pos.getStrikePrice()).setPositionOptionExpiry(expiry).setPositionPrice(pos.getClosingPrice()).addPosition();
            }

        }
        // build account level
        builder.setAccountStrategyGroupName(marginRequest.getAccountStrategyGroup());
        String accountResponseDetailLevel = marginRequest.getAccountResponseDetailLevel();
        if (accountResponseDetailLevel != null) {
            builder.setResponseDetailLevel(Account.ResponseDetailLevel.valueOf(accountResponseDetailLevel) );
        }
        AccountPairingRequest pairingRequest = builder.build(marginRequest.getAccountNumber());
        String pairingRequestJson = gsonInstance.toJson(pairingRequest);
        return pairingRequest;
    }
}
