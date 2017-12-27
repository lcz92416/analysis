package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * IT隶属部门
 * created by lichenzhe on 2017/12/21
 */
public class ITDepartmentModel {
    public String id;
    public int count;
    public String itdepartment;
    public String date;
    public Date createTime;
//    //部门中文
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

    public String getItdepartment() {
        return itdepartment;
    }

    public void setItdepartment(String itdepartment) {
        this.itdepartment = itdepartment;
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
