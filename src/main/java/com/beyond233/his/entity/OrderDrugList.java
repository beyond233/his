package com.beyond233.his.entity;

import java.io.Serializable;

public class OrderDrugList implements Serializable {
    private Integer orderId;

    private Integer drugId;

    private Integer orderDrugCount;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getOrderDrugCount() {
        return orderDrugCount;
    }

    public void setOrderDrugCount(Integer orderDrugCount) {
        this.orderDrugCount = orderDrugCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", drugId=").append(drugId);
        sb.append(", orderDrugCount=").append(orderDrugCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}