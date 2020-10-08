package com.beyond233.his.vo;


import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-14 20:31
 */
public class DepartmentTypeAndName {
    private String departType;
    private List<DepartmentIdAndNameRecord> departList;

    public String getDepartType() {
        return departType;
    }

    public void setDepartType(String departType) {
        this.departType = departType;
    }

    public List<DepartmentIdAndNameRecord> getDepartList() {
        return departList;
    }

    public void setDepartList(List<DepartmentIdAndNameRecord> departList) {
        this.departList = departList;
    }

    @Override
    public String toString() {
        return "DepartmentTypeAndName{" +
                "departType='" + departType + '\'' +
                ", departList=" + departList +
                '}';
    }
}
