package cn.com.betasoft.saas.analysis.dao.impl;

import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.dao.PGSQLBaseDao;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.mapper.PGSQLBaseMapper;
import cn.com.betasoft.saas.analysis.model.ITDepartmentModel;
import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

@Repository
public class PGSQLBaseDaoImpl implements PGSQLBaseDao {
    @Autowired
    private PGSQLBaseMapper pgsqlBaseMapper;

    @Override
//    @DataSourceTypeAnno(DataSourceEnum.pgsql)
    public RegisterCountModel selectRegistersCount(){
        return pgsqlBaseMapper.selectRegistersCount();
    }

    @Override
//    @DataSourceTypeAnno(DataSourceEnum.pgsql)
    public List<ProblemTypeCountModel> selectProblemTypeCount(){
        return pgsqlBaseMapper.selectProblemTypeCount();
    }

    @Override
//    @DataSourceTypeAnno(DataSourceEnum.pgsql)
    public List<ITDepartmentModel> selectITDepartmentCount(){
        return pgsqlBaseMapper.selectITDepartmentCount();

    }
}
