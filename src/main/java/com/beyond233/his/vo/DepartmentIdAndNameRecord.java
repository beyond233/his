package com.beyond233.his.vo;

/**
 * <p>项目文档: 科室id 和名称 数据封装</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-09 20:47
 */
public class DepartmentIdAndNameRecord {
    //科室id
    private Integer departmentId;
    //科室名称
    private String departmentName;

    @Override
    public String toString() {
        return "DepartmentIdAndNameRecord{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

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
        this.departmentName = departmentName;
    }
}
