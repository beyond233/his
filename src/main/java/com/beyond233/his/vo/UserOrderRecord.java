package com.beyond233.his.vo;

/**
 * <p>项目文档: 患者就诊记录</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-06 10:20
 */
public class UserOrderRecord {
    //就诊id
    private String orderId;
    //就诊时间
    private String orderDate;
    //就诊科室
    private String departmentName;
    //看诊医生
    private String empName;
    //所患症状
    private String orderSymptom;
    //诊断结果
    private String orderResult;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public String getOrderSymptom() {
        return orderSymptom;
    }

    public void setOrderSymptom(String orderSymptom) {
        this.orderSymptom = orderSymptom;
    }

    public String getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(String orderResult) {
        this.orderResult = orderResult;
    }

    @Override
    public String toString() {
        return "UserOrderRecord{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", empName='" + empName + '\'' +
                ", orderSymptom='" + orderSymptom + '\'' +
                ", orderResult='" + orderResult + '\'' +
                '}';
    }
}
