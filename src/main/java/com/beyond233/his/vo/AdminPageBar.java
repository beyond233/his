package com.beyond233.his.vo;

import java.util.List;

/**
 * <p>项目文档: 管理界面侧边导航栏数据封装</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-09 20:40
 */
public class AdminPageBar {
    //科室类型集合
    private List<String> departTypeList;
    //科室id和名称集合
    private List<DepartmentIdAndNameRecord> departmentIdAndNameList;
    //药品分类信息集合


    public List<String> getDepartTypeList() {
        return departTypeList;
    }

    public void setDepartTypeList(List<String> departTypeList) {
        this.departTypeList = departTypeList;
    }

    public List<DepartmentIdAndNameRecord> getDepartmentIdAndNameList() {
        return departmentIdAndNameList;
    }

    public void setDepartmentIdAndNameList(List<DepartmentIdAndNameRecord> departmentIdAndNameList) {
        this.departmentIdAndNameList = departmentIdAndNameList;
    }

    @Override
    public String toString() {
        return "AdminPageBar{" +
                "departTypeList=" + departTypeList +
                ", departmentIdAndNameList=" + departmentIdAndNameList +
                '}';
    }
}
