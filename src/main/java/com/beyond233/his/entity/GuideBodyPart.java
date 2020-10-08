package com.beyond233.his.entity;

import java.io.Serializable;

public class GuideBodyPart implements Serializable {
    private Integer bodypartId;

    private String bodypartName;

    private static final long serialVersionUID = 1L;

    public Integer getBodypartId() {
        return bodypartId;
    }

    public void setBodypartId(Integer bodypartId) {
        this.bodypartId = bodypartId;
    }

    public String getBodypartName() {
        return bodypartName;
    }

    public void setBodypartName(String bodypartName) {
        this.bodypartName = bodypartName == null ? null : bodypartName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bodypartId=").append(bodypartId);
        sb.append(", bodypartName=").append(bodypartName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}