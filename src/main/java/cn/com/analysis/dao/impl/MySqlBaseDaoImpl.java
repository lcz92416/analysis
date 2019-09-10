package cn.com.analysis.dao.impl;

import cn.com.analysis.annotation.DataSourceTypeAnno;
import cn.com.analysis.datasource.DataSourceEnum;
import cn.com.analysis.mapper.MySqlBaseMapper;
import cn.com.analysis.model.AgentRatioModel;
import cn.com.analysis.model.AreaRatioModel;
import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.IndustryRatioModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.ProductTypeRatioModel;
import cn.com.analysis.model.RegisterCountModel;
import cn.com.analysis.dao.MySqlBaseDao;
import cn.com.analysis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

@Repository
public class MySqlBaseDaoImpl implements MySqlBaseDao {
    @Autowired
    private MySqlBaseMapper mySqlBaseMapper;

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<RegisterCountModel> selectRegistersCount() {
        return mySqlBaseMapper.selectRegistersCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public String insertRegistersCount(RegisterCountModel registerCountModel){
            mySqlBaseMapper.insertRegistersCount(registerCountModel);
        String l=registerCountModel.getId();
        return l;
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<ProblemTypeCountModel> selectProblemTypeCount(){
        return mySqlBaseMapper.selectProblemTypeCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public String insertProblemTypeCount(ProblemTypeCountModel problemTypeCountModel){
        mySqlBaseMapper.insertProblemTypeCount(problemTypeCountModel);
        String l=problemTypeCountModel.getId();
        return l;
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<ITDepartmentModel> selectITDepartmentCount(){
        return mySqlBaseMapper.selectITDepartmentCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public String insertITDepartment(ITDepartmentModel itDepartmentModel){
        mySqlBaseMapper.insertITDepartment(itDepartmentModel);
        String l=itDepartmentModel.getId();
        return l;
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<ProductTypeRatioModel> selectProductTypeRatioCount(){
        return mySqlBaseMapper.selectProductTypeRatioCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<AgentRatioModel> selectAgentRatioCount(){
        return mySqlBaseMapper.selectAgentRatioCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<AreaRatioModel> selectAreaRatioCount(){
        return mySqlBaseMapper.selectAreaRatioCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public List<IndustryRatioModel> selectIndustryRatioCount(){
        return mySqlBaseMapper.selectIndustryRatioCount();
    }

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    @Override
    public String getCollectionTime(){
        return mySqlBaseMapper.getCollectionTime();
    }
}
