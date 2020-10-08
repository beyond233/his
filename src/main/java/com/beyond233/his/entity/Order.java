package com.beyond233.his.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer orderId;

    private Date orderDate;

    private Integer userId;

    private Integer empId;

    private String orderSymptom;

    private String orderResult;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getOrderSymptom() {
        return orderSymptom;
    }

    public void setOrderSymptom(String orderSymptom) {
        this.orderSymptom = orderSymptom == null ? null : orderSymptom.trim();
    }

    public String getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(String orderResult) {
        this.orderResult = orderResult == null ? null : orderResult.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", userId=").append(userId);
        sb.append(", empId=").append(empId);
        sb.append(", orderSymptom=").append(orderSymptom);
        sb.append(", orderResult=").append(orderResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}