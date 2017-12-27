package cn.com.betasoft.saas.analysis.mapper;


import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.model.SysRoleModel;
import cn.com.betasoft.saas.analysis.model.SysUserModel;

/**
 * created by lichenzhe on 2017/12/11
 */

import java.util.List;

public interface SysUserByMySqlMapper {
    public SysUserModel findSysByUserName(String userName);

    public List<SysRoleModel> findRolesByUserName(String userName);

}
