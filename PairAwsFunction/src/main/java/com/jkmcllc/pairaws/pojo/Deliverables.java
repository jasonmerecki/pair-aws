package com.jkmcllc.pairaws.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Deliverables {

    @SerializedName("SymbolDeliverables")
    @Expose
    private List<SymbolDeliverable> symbolDeliverables = null;
    @SerializedName("CashDeliverableValue")
    @Expose
    private String cashDeliverableValue;

    public List<SymbolDeliverable> getSymbolDeliverables() {
        return symbolDeliverables;
    }

    public void setSymbolDeliverables(List<SymbolDeliverable> symbolDeliverables) {
        this.symbolDeliverables = symbolDeliverables;
    }

    public String getCashDeliverableValue() {
        return cashDeliverableValue;
    }

    public void setCashDeliverableValue(String cashDeliverableValue) {
        this.cashDeliverableValue = cashDeliverableValue;
    }

}