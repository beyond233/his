package com.beyond233.his.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Drug implements Serializable {
    private Integer drugId;

    private String drugName;

    private String drugSize;

    private BigDecimal drugPrice;

    private Integer drugCount;

    private static final long serialVersionUID = 1L;

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getDrugSize() {
        return drugSize;
    }

    public void setDrugSize(String drugSize) {
        this.drugSize = drugSize == null ? null : drugSize.trim();
    }

    public BigDecimal getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(BigDecimal drugPrice) {
        this.drugPrice = drugPrice;
    }

    public Integer getDrugCount() {
        return drugCount;
    }

    public void setDrugCount(Integer drugCount) {
        this.drugCount = drugCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugId=").append(drugId);
        sb.append(", drugName=").append(drugName);
        sb.append(", drugSize=").append(drugSize);
        sb.append(", drugPrice=").append(drugPrice);
        sb.append(", drugCount=").append(drugCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}