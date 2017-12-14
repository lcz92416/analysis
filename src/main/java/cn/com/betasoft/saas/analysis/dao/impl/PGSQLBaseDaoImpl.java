package cn.com.betasoft.saas.analysis.dao.impl;

import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.dao.PGSQLBaseDao;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.mapper.PGSQLBaseMapper;
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

    @DataSourceTypeAnno(DataSourceEnum.pgsql)
    public List<Object> selectUser() {
        return pgsqlBaseMapper.selectUser();
    }
}
