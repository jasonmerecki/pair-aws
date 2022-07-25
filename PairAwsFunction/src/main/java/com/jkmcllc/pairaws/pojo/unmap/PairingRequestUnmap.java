package com.jkmcllc.pairaws.pojo.unmap;

import com.jkmcllc.aupair01.pairing.PairingRequest;
import com.jkmcllc.aupair01.structure.Account;
import com.jkmcllc.aupair01.structure.OptionRoot;

import java.util.List;
import java.util.Map;

public class PairingRequestUnmap implements PairingRequest {
    private List<Account> accounts;
    private Map<String, OptionRoot> optionRoots;

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public Map<String, OptionRoot> getOptionRoots() {
        return optionRoots;
    }

    public void setOptionRoots(Map<String, OptionRoot> optionRoots) {
        this.optionRoots = optionRoots;
    }

    @Override
    public boolean isRequestAllStrategyLists() {
        return false;
    }

    @Override
    public String requestType() {
        return "PairingRequest";
    }
}
