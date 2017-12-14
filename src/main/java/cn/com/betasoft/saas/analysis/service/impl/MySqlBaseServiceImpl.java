package cn.com.betasoft.saas.analysis.service.impl;

import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.dao.MySqlBaseDao;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.mapper.SysUserByMySqlMapper;
import cn.com.betasoft.saas.analysis.model.SysUserModel;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

@Service
public class MySqlBaseServiceImpl implements MySqlBaseService {

    @Autowired
    private MySqlBaseDao mySqlBaseDao;

    @DataSourceTypeAnno(DataSourceEnum.mysql)
    public List<SysUserModel> selectUser() {
        return mySqlBaseDao.selectUser();
    }
}