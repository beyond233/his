package com.beyond233.his.entity;

import java.io.Serializable;
import java.util.Date;

public class Register implements Serializable {
    private Integer registerId;

    private Integer departmentId;

    private Integer empId;

    private Date registerDate;

    private Double registerPrice;

    private Integer registerAmount;

    private Integer registerBalance;

    private static final long serialVersionUID = 1L;

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Double getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(Double registerPrice) {
        this.registerPrice = registerPrice;
    }

    public Integer getRegisterAmount() {
        return registerAmount;
    }

    public void setRegisterAmount(Integer registerAmount) {
        this.registerAmount = registerAmount;
    }

    public Integer getRegisterBalance() {
        return registerBalance;
    }

    public void setRegisterBalance(Integer registerBalance) {
        this.registerBalance = registerBalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registerId=").append(registerId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", empId=").append(empId);
        sb.append(", registerDate=").append(registerDate);
        sb.append(", registerPrice=").append(registerPrice);
        sb.append(", registerAmount=").append(registerAmount);
        sb.append(", registerBalance=").append(registerBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}