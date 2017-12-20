package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * created by lichenzhe on 2017/12/20
 */
public class IndustryRatioModel {
    public static final String TYPE_PARTNER = "partner";
    public static final String TYPE_REGISTER = "register";
    public static final String TYPE_ALL = "all";

    /**
     *  主键
     */
    private String id;

    /**
     * 类型 值包含 partner-运营商  register-注册用户  all-所有类型用户
     */
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type='" + type + '\'' +
                ", industry='" + industry + '\'' +
                ", count=" + count +
                ", date='" + date + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
