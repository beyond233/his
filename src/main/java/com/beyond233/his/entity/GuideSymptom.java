package com.beyond233.his.entity;

import java.io.Serializable;

public class GuideSymptom implements Serializable {
    private Integer symptomId;

    private String symptomName;

    private Integer bodypartId;

    private static final long serialVersionUID = 1L;

    public Integer getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName == null ? null : symptomName.trim();
    }

    public Integer getBodypartId() {
        return bodypartId;
    }

    public void setBodypartId(Integer bodypartId) {
        this.bodypartId = bodypartId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", symptomId=").append(symptomId);
        sb.append(", symptomName=").append(symptomName);
        sb.append(", bodypartId=").append(bodypartId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}