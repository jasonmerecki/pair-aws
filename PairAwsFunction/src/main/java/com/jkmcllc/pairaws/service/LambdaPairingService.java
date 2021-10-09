package com.jkmcllc.pairaws.service;

import com.jkmcllc.aupair01.pairing.AccountPairingRequest;
import com.jkmcllc.aupair01.pairing.AccountPairingResponse;
import com.jkmcllc.aupair01.pairing.impl.PairingService;
import com.jkmcllc.pairaws.pojo.AccountMarginRequest;

public class LambdaPairingService {
    private final PairingService pairingService = PairingService.getInstance();
    private static LambdaPairingService instance = null;
    private LambdaPairingService() {};
    public static LambdaPairingService getInstance() {
        if (instance == null) {
            synchronized (LambdaPairingService.class) {
                if (instance == null) {
                    instance = new LambdaPairingService();
                }
            }
        }
        return instance;
    }

    public AccountPairingResponse processAccountRequest(AccountMarginRequest marginRequest) {
        AccountPairingRequest pairingRequest = LambdaPairingBuilder.buildAccountPairingRequest(marginRequest);
        AccountPairingResponse accountPairingResponse = processAccountRequestInternal(pairingRequest);
        return accountPairingResponse;
    }

    private AccountPairingResponse processAccountRequestInternal(AccountPairingRequest pairingRequest) {
        AccountPairingResponse accountPairingResponse = pairingService.processAccountRequest(pairingRequest);
        return accountPairingResponse;
    }


}
