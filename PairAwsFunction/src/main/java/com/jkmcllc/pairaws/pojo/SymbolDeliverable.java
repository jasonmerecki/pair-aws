package com.jkmcllc.pairaws.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SymbolDeliverable {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("maintenancePct")
    @Expose
    private String maintenancePct;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaintenancePct() {
        return maintenancePct;
    }

    public void setMaintenancePct(String maintenancePct) {
        this.maintenancePct = maintenancePct;
    }

}
