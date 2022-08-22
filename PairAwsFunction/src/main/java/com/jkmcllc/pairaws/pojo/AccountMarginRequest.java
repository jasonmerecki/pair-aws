package com.jkmcllc.pairaws.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountMarginRequest {

    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("AccountStrategyGroup")
    @Expose
    private String accountStrategyGroup;
    @SerializedName("AccountResponseDetailLevel")
    @Expose
    private String accountResponseDetailLevel;
    @SerializedName("AccountBalance")
    @Expose
    private AccountBalance accountBalance;
    @SerializedName("Positions")
    @Expose
    private List<Position> positions = null;
    @SerializedName("OptionRoots")
    @Expose
    private List<OptionRoot> optionRoots;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountBalance getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(AccountBalance accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<OptionRoot> getOptionRoots() {
        return optionRoots;
    }

    public void setOptionRoots(List<OptionRoot> optionRoots) {
        this.optionRoots = optionRoots;
    }

    public String getAccountStrategyGroup() {
        return accountStrategyGroup;
    }

    public void setAccountStrategyGroup(String accountStrategyGroup) {
        this.accountStrategyGroup = accountStrategyGroup;
    }

    public String getAccountResponseDetailLevel() {
        return accountResponseDetailLevel;
    }

    public void setAccountResponseDetailLevel(String accountResponseDetailLevel) {
        this.accountResponseDetailLevel = accountResponseDetailLevel;
    }
}
