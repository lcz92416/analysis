package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * created by lichenzhe on 2017/12/22
 */
public class ProductTypeRatioModel {
    public String id;
    public String productType;
    public int count;
    public String date;
    public Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
