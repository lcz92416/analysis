package cn.com.betasoft.saas.analysis.service.impl;

import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.dao.PGSQLBaseDao;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.mapper.PGSQLBaseMapper;
import cn.com.betasoft.saas.analysis.service.PGSQLBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

@Service
public class PGSQLBaseServiceImpl implements PGSQLBaseService {

    @Autowired
    private PGSQLBaseDao pgsqlBaseDao;

    @DataSourceTypeAnno(DataSourceEnum.pgsql)
    public List<Object> selectUser() {
        return pgsqlBaseDao.selectUser();
    }
}
