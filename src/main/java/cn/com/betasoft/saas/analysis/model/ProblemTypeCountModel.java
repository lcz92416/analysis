package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * 问题类型
 * created by lichenzhe on 2017/12/18
 */
public class ProblemTypeCountModel {
    public String id;
    public int count;
    public String modulename;
    public String date;
    public Date createTime;

//    //问题类型中文
//    public String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
