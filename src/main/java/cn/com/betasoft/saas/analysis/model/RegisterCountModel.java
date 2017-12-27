package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * 注册数量
 * created by lichenzhe on 2017/12/18
 */
public class RegisterCountModel {
    public String id;
    public int count;
    public String date;
    public Date createTime;

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
