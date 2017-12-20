package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * created by lichenzhe on 2017/12/18
 */
public class RegisterCountModel {
    public Long id;
    public int count;
//    public Date registerDate;
    public Date analysisDate;

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

//    public Date getRegisterDate() {
//        return registerDate;
//    }
//
//    public void setRegisterDate(Date registerDate) {
//        this.registerDate = registerDate;
//    }

    public Date getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }
}
