package cn.com.betasoft.saas.analysis.mapper;

import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;
import cn.com.betasoft.saas.analysis.model.SysUserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Generated;
import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface MySqlBaseMapper {
    @Select("select * from register_count")
    public List<RegisterCountModel> selectRegistersCount();

    @Insert("INSERT INTO register_count(count,analysisDate) VALUES(#{registerCountModel.count},#{registerCountModel.analysisDate} )")
    @Options(useGeneratedKeys = true, keyProperty = "registerCountModel.id",keyColumn = "id")
    public void insertRegistersCount(@Param("registerCountModel") RegisterCountModel registerCountModel);

    @Select("select * from problem_type order by workordertype")
    public List<ProblemTypeCountModel> selectProblemTypeCount();

    @Insert("INSERT INTO problem_type(count,workordertype,analysisDate) VALUES(#{problemTypeCountModel.count},#{problemTypeCountModel.workOrderType},#{problemTypeCountModel.analysisDate} )")
    @Options(useGeneratedKeys = true, keyProperty = "problemTypeCountModel.id",keyColumn = "id")
    public void insertProblemTypeCount(@Param("problemTypeCountModel") ProblemTypeCountModel problemTypeCountModel);
}
