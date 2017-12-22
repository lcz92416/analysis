package cn.com.betasoft.saas.analysis.model;

import java.sql.Date;

/**
 * 地域分布
 * created by lichenzhe on 2017/12/21
 */
public class LocalDistributionModel {
    public Long id;
    public int provinceCount;
    public String province;
    public String city;
    public int cityCount;
    public Date analysisDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProvinceCount() {
        return provinceCount;
    }

    public void setProvinceCount(int provinceCount) {
        this.provinceCount = provinceCount;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }

    public Date getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }
}
