package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * 行业分布
 * created by lichenzhe on 2017/12/20
 */
public class IndustryRatioModel {

    /**
     *  主键
     */
    private String id;


    /**
     * 行业
     */
    private String industry;

    /**
     * 各行业对应数量
     */
    private Integer count;

    /**
     * 数据对应日期  yyyy-MM-dd形式
     */
    private String date;

    /**
     * 数据生成时间  日期格式
     */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IndustryRatioModel{" +
                "id='" + id + '\'' +
                ", industry='" + industry + '\'' +
                ", count=" + count +
                ", date='" + date + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
