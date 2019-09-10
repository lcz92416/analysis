package cn.com.analysis.dao.impl;

import cn.com.analysis.mapper.PGSQLBaseMapper;
import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.RegisterCountModel;
import cn.com.analysis.dao.PGSQLBaseDao;
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
