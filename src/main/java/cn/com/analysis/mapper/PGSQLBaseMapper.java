package cn.com.analysis.mapper;

import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.RegisterCountModel;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface PGSQLBaseMapper {
    //    @SelectProvider(type= SysUserByMySqlProvider.class,method = "findSysByUserName")
//    @Select("SELECT TO_CHAR(TO_TIMESTAMP(CREATETIME/1000::BIGINT), 'YYYY-MM-DD') AS registerDate , NOW() AS analysisDate, COUNT(*) AS count FROM  COMMUNITY_USERINFO  GROUP BY registerDate ORDER BY registerDate;")
    @Select("SELECT NOW() AS analysisDate, COUNT(*) AS count FROM  COMMUNITY_USERINFO")
    public RegisterCountModel selectRegistersCount();

    @Select("SELECT NOW() AS analysisDate,WORKORDERTYPE,COUNT(*)  FROM SCOMMUNITY_WORK_ORDER GROUP BY WORKORDERTYPE")
    public List<ProblemTypeCountModel> selectProblemTypeCount();

    @Select("SELECT NOW() AS analysisDate,ITMANAGEDEPARTMENT as departmentType ,COUNT(*)  FROM COMMUNITY_USERINFO GROUP BY departmentType")
    public List<ITDepartmentModel> selectITDepartmentCount();
}
