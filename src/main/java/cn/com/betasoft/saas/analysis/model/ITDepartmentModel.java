package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * IT隶属部门
 * created by lichenzhe on 2017/12/21
 */
public class ITDepartmentModel {
    public Long id;
    public int count;
    public String departmentType;
    public Date analysisDate;

    //部门中文
    public String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public Date getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
