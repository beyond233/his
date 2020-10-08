package com.beyond233.his.entity;

import java.io.Serializable;

public class GuideAdvice implements Serializable {
    private Integer adviceId;

    private String adviceContent;

    private Integer departmentId;

    private String ansowers;

    private static final long serialVersionUID = 1L;

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getAnsowers() {
        return ansowers;
    }

    public void setAnsowers(String ansowers) {
        this.ansowers = ansowers == null ? null : ansowers.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adviceId=").append(adviceId);
        sb.append(", adviceContent=").append(adviceContent);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", ansowers=").append(ansowers);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}