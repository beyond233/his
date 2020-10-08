package com.beyond233.his.vo;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>项目文档: 专家出诊记录</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-14 15:41
 */
public class ExpertRegisterRecord {
    //单号id
    private String registerId;
    //预约时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String registerDate;
    //科室类型
    private String departmentType;
    //科室名称
    private String departmentName;
    //预约医生
    private String empName;
    //医生id
    private Integer empId;
    //单号价格
    private double registerPrice;
    //总号数
    private Integer registerAmount;
    //剩余号数
    private Integer registerBalance;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public double getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(double registerPrice) {
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
        return "ExpertRegisterRecord{" +
                "registerId='" + registerId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", departmentType='" + departmentType + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", empName='" + empName + '\'' +
                ", empId=" + empId +
                ", registerPrice=" + registerPrice +
                ", registerAmount=" + registerAmount +
                ", registerBalance=" + registerBalance +
                '}';
    }
}


