package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * created by lichenzhe on 2017/12/22
 */
public class AgentRatioModel {
    public String id;
    public String agentname;
    public String count;
    public String date;
    public Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
