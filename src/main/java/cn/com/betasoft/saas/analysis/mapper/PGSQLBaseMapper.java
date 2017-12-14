package cn.com.betasoft.saas.analysis.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface PGSQLBaseMapper {
    //    @SelectProvider(type= SysUserByMySqlProvider.class,method = "findSysByUserName")
    @Select("select * from saas_order_user_in_vms")
    public List<Object> selectUser();
}
