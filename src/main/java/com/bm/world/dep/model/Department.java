package com.bm.world.dep.model;

import com.bm.world.dep.ApplicationConstants;

import javax.persistence.*;

/**
 * This entity used for to store and get the details of department
 */
@Entity
@Table(name = ApplicationConstants.DEPARTMENT_DETAILS_TABLE)
public class Department {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer departmentId;

    @Column(name = "dep_name")
    private String departmentName;

    @Column(name = "dept_head")
    private String departmentHead;

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

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                '}';
    }
}
