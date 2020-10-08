package com.beyond233.his.vo;

/**
 * <p>项目文档: 患者预约记录的数据封装VO</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-05 19:59
 */
public class UserRegisterRecord {
    //单号id
    private String registerId;
    //预约时间
    private String registerDate;
    //预约科室
    private String departmentName;
    //预约医生
    private String empName;
    //单号价格
    private double registerPrice;

    @Override
    public String toString() {
        return "UserOrderRecord{" +
                "registerId='" + registerId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", empName='" + empName + '\'' +
                ", registerPrice=" + registerPrice +
                ", status=" + status +
                '}';
    }

    public double getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(double registerPrice) {
        this.registerPrice = registerPrice;
    }

    //单号状态
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
