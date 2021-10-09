package com.jkmcllc.pairaws.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class OptionRoot {

    @SerializedName("OptionRootSymbol")
    @Expose
    private String optionRootSymbol;
    @SerializedName("ExerciseStyle")
    @Expose
    private String exerciseStyle;
    @SerializedName("UnderlyerType")
    @Expose
    private String underlyerType;
    @SerializedName("Multiplier")
    @Expose
    private String multiplier;
    @SerializedName("Deliverables")
    @Expose
    private Deliverables deliverables;

    public String getOptionRootSymbol() {
        return optionRootSymbol;
    }

    public void setOptionRootSymbol(String optionRootSymbol) {
        this.optionRootSymbol = optionRootSymbol;
    }

    public String getExerciseStyle() {
        return exerciseStyle;
    }

    public void setExerciseStyle(String exerciseStyle) {
        this.exerciseStyle = exerciseStyle;
    }

    public String getUnderlyerType() {
        return underlyerType;
    }

    public void setUnderlyerType(String underlyerType) {
        this.underlyerType = underlyerType;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public Deliverables getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(Deliverables deliverables) {
        this.deliverables = deliverables;
    }

}
