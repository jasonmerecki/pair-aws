package com.jkmcllc.pairaws.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AccountBalance {

    @SerializedName("TotalEquity")
    @Expose
    private String totalEquity;
    @SerializedName("CashTradeBalance")
    @Expose
    private String cashTradeBalance;
    @SerializedName("MarginTradeBalance")
    @Expose
    private String marginTradeBalance;
    @SerializedName("ShortTradeBalance")
    @Expose
    private String shortTradeBalance;
    @SerializedName("MoneyMarketTradeBalance")
    @Expose
    private String moneyMarketTradeBalance;
    @SerializedName("SMA")
    @Expose
    private String sma;

    public String getTotalEquity() {
        return totalEquity;
    }

    public void setTotalEquity(String totalEquity) {
        this.totalEquity = totalEquity;
    }

    public String getCashTradeBalance() {
        return cashTradeBalance;
    }

    public void setCashTradeBalance(String cashTradeBalance) {
        this.cashTradeBalance = cashTradeBalance;
    }

    public String getMarginTradeBalance() {
        return marginTradeBalance;
    }

    public void setMarginTradeBalance(String marginTradeBalance) {
        this.marginTradeBalance = marginTradeBalance;
    }

    public String getShortTradeBalance() {
        return shortTradeBalance;
    }

    public void setShortTradeBalance(String shortTradeBalance) {
        this.shortTradeBalance = shortTradeBalance;
    }

    public String getMoneyMarketTradeBalance() {
        return moneyMarketTradeBalance;
    }

    public void setMoneyMarketTradeBalance(String moneyMarketTradeBalance) {
        this.moneyMarketTradeBalance = moneyMarketTradeBalance;
    }

    public String getSma() {
        return sma;
    }

    public void setSma(String sma) {
        this.sma = sma;
    }

}
