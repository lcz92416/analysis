package cn.com.betasoft.saas.analysis.mapper;

import cn.com.betasoft.saas.analysis.model.SysUserModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface MySqlBaseMapper {
    @Select("select * from Sys_User")
    public List<SysUserModel> selectUser();
}
