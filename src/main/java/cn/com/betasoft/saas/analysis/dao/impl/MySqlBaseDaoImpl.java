package cn.com.betasoft.saas.analysis.dao.impl;

import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.dao.MySqlBaseDao;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.mapper.MySqlBaseMapper;
import cn.com.betasoft.saas.analysis.mapper.SysUserByMySqlMapper;
import cn.com.betasoft.saas.analysis.model.SysUserModel;
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
    public List<SysUserModel> selectUser() {
        return mySqlBaseMapper.selectUser();
    }

}
