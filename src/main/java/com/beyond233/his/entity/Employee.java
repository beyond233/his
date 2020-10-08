package com.beyond233.his.entity;

import java.io.Serializable;

/**
 * @author BEYOND
 */
public class Employee implements Serializable {
    private Integer empId;

    private String empPassword;

    private String empName;

    private String empSex;

    private Integer empAge;

    private String empPhone;

    private String empCareer;

    private String empTitle;

    private Integer departmentId;

    private String empAwards;

    private Integer roleId;

    private String empIntro;

    private String empMajor;

    private static final long serialVersionUID = 1L;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword == null ? null : empPassword.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex == null ? null : empSex.trim();
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone == null ? null : empPhone.trim();
    }

    public String getEmpCareer() {
        return empCareer;
    }

    public void setEmpCareer(String empCareer) {
        this.empCareer = empCareer == null ? null : empCareer.trim();
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = empTitle == null ? null : empTitle.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmpAwards() {
        return empAwards;
    }

    public void setEmpAwards(String empAwards) {
        this.empAwards = empAwards == null ? null : empAwards.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getEmpIntro() {
        return empIntro;
    }

    public void setEmpIntro(String empIntro) {
        this.empIntro = empIntro == null ? null : empIntro.trim();
    }

    public String getEmpMajor() {
        return empMajor;
    }

    public void setEmpMajor(String empMajor) {
        this.empMajor = empMajor == null ? null : empMajor.trim();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", empId=" + empId +
                ", empPassword=" + empPassword +
                ", empName=" + empName +
                ", empSex=" + empSex +
                ", empAge=" + empAge +
                ", empPhone=" + empPhone +
                ", empCareer=" + empCareer +
                ", empTitle=" + empTitle +
                ", departmentId=" + departmentId +
                ", empAwards=" + empAwards +
                ", roleId=" + roleId +
                ", empIntro=" + empIntro +
                ", empMajor=" + empMajor +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}