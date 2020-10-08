package com.beyond233.his.entity;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer departmentId;

    private String departmentName;

    private String departmentType;

    private String departmentAddr;

    private String departmentInfo;

    private static final long serialVersionUID = 1L;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType == null ? null : departmentType.trim();
    }

    public String getDepartmentAddr() {
        return departmentAddr;
    }

    public void setDepartmentAddr(String departmentAddr) {
        this.departmentAddr = departmentAddr == null ? null : departmentAddr.trim();
    }

    public String getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(String departmentInfo) {
        this.departmentInfo = departmentInfo == null ? null : departmentInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", departmentType=").append(departmentType);
        sb.append(", departmentAddr=").append(departmentAddr);
        sb.append(", departmentInfo=").append(departmentInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}