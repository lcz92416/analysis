package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * 问题类型
 * created by lichenzhe on 2017/12/18
 */
public class ProblemTypeCountModel {
    public Long id;
    public int count;
    public int workOrderType;
    public Date analysisDate;

    //问题类型中文
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

    public int getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(int workOrderType) {
        this.workOrderType = workOrderType;
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
