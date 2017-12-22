package cn.com.betasoft.saas.analysis.mapper;

import cn.com.betasoft.saas.analysis.model.ITDepartmentModel;
import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface PGSQLBaseMapper {
    //    @SelectProvider(type= SysUserByMySqlProvider.class,method = "findSysByUserName")
//    @Select("SELECT TO_CHAR(TO_TIMESTAMP(CREATETIME/1000::BIGINT), 'YYYY-MM-DD') AS registerDate , NOW() AS analysisDate, COUNT(*) AS count FROM  SAAS_COMMUNITY_USERINFO  GROUP BY registerDate ORDER BY registerDate;")
    @Select("SELECT NOW() AS analysisDate, COUNT(*) AS count FROM  SAAS_COMMUNITY_USERINFO")
    public RegisterCountModel selectRegistersCount();

    @Select("SELECT NOW() AS analysisDate,WORKORDERTYPE,COUNT(*)  FROM SAAS_COMMUNITY_WORK_ORDER GROUP BY WORKORDERTYPE")
    public List<ProblemTypeCountModel> selectProblemTypeCount();

    @Select("SELECT NOW() AS analysisDate,ITMANAGEDEPARTMENT as departmentType ,COUNT(*)  FROM SAAS_COMMUNITY_USERINFO GROUP BY departmentType")
    public List<ITDepartmentModel> selectITDepartmentCount();
}
