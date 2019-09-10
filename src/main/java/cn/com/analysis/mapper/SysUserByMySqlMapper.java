package cn.com.analysis.mapper;


import cn.com.analysis.model.SysRoleModel;
import cn.com.analysis.model.SysUserModel;

/**
 * created by lichenzhe on 2017/12/11
 */

import java.util.List;

public interface SysUserByMySqlMapper {
    public SysUserModel findSysByUserName(String userName);

    public List<SysRoleModel> findRolesByUserName(String userName);

}
