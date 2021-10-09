package com.jkmcllc.pairaws.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Position {

    @SerializedName("AccountType")
    @Expose
    private String accountType;
    @SerializedName("Symbol")
    @Expose
    private String symbol;
    @SerializedName("SettleQuantity")
    @Expose
    private String settleQuantity;
    @SerializedName("SecurityTypeCode")
    @Expose
    private String securityTypeCode;
    @SerializedName("ClosingPrice")
    @Expose
    private String closingPrice;
    @SerializedName("OptionSymbolRoot")
    @Expose
    private String optionSymbolRoot;
    @SerializedName("OptionContractDate")
    @Expose
    private String optionContractDate;
    @SerializedName("StrikePrice")
    @Expose
    private String strikePrice;
    @SerializedName("CallPut")
    @Expose
    private String callPut;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSettleQuantity() {
        return settleQuantity;
    }

    public void setSettleQuantity(String settleQuantity) {
        this.settleQuantity = settleQuantity;
    }

    public String getSecurityTypeCode() {
        return securityTypeCode;
    }

    public void setSecurityTypeCode(String securityTypeCode) {
        this.securityTypeCode = securityTypeCode;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getOptionSymbolRoot() {
        return optionSymbolRoot;
    }

    public void setOptionSymbolRoot(String optionSymbolRoot) {
        this.optionSymbolRoot = optionSymbolRoot;
    }

    public String getOptionContractDate() {
        return optionContractDate;
    }

    public void setOptionContractDate(String optionContractDate) {
        this.optionContractDate = optionContractDate;
    }

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getCallPut() {
        return callPut;
    }

    public void setCallPut(String callPut) {
        this.callPut = callPut;
    }

}
