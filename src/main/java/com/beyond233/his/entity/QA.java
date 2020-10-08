package com.beyond233.his.entity;

import java.io.Serializable;

public class QA implements Serializable {
    private Integer qaId;

    private String qaQ;

    private String qaA;

    private static final long serialVersionUID = 1L;

    public Integer getQaId() {
        return qaId;
    }

    public void setQaId(Integer qaId) {
        this.qaId = qaId;
    }

    public String getQaQ() {
        return qaQ;
    }

    public void setQaQ(String qaQ) {
        this.qaQ = qaQ == null ? null : qaQ.trim();
    }

    public String getQaA() {
        return qaA;
    }

    public void setQaA(String qaA) {
        this.qaA = qaA == null ? null : qaA.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qaId=").append(qaId);
        sb.append(", qaQ=").append(qaQ);
        sb.append(", qaA=").append(qaA);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}