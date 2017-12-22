package cn.com.betasoft.saas.analysis.mapper;

import cn.com.betasoft.saas.analysis.model.*;
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
    @Options(useGeneratedKeys = true, keyProperty = "registerCountModel.id", keyColumn = "id")
    public void insertRegistersCount(@Param("registerCountModel") RegisterCountModel registerCountModel);

    @Select("select * from problem_type order by workordertype")
    public List<ProblemTypeCountModel> selectProblemTypeCount();

    @Insert("INSERT INTO problem_type(count,workordertype,analysisDate) VALUES(#{problemTypeCountModel.count},#{problemTypeCountModel.workOrderType},#{problemTypeCountModel.analysisDate} )")
    @Options(useGeneratedKeys = true, keyProperty = "problemTypeCountModel.id", keyColumn = "id")
    public void insertProblemTypeCount(@Param("problemTypeCountModel") ProblemTypeCountModel problemTypeCountModel);

    @Select("SELECT * FROM IT_DEPARTMENT WHERE ANALYSISDATE=(SELECT MAX(ANALYSISDATE) FROM IT_DEPARTMENT)")
    public List<ITDepartmentModel> selectITDepartmentCount();

    @Insert("INSERT INTO it_department(count,departmentType,analysisDate) VALUES(#{itDepartmentModel.count},#{itDepartmentModel.departmentType},#{itDepartmentModel.analysisDate} )")
    @Options(useGeneratedKeys = true, keyProperty = "itDepartmentModel.id", keyColumn = "id")
    public void insertITDepartment(@Param("itDepartmentModel") ITDepartmentModel itDepartmentModel);

    @Select("SELECT * FROM infosystem_producttyperatio WHERE date=(SELECT MAX(date) FROM infosystem_producttyperatio)")
    public List<ProductTypeRatioModel> selectProductTypeRatioCount();

    //    @Select("SELECT type,sum(count) as count FROM infosystem_agentratio WHERE date=(SELECT MAX(date) FROM infosystem_agentratio) group by type")
    @Select("SELECT * FROM infosystem_agentratio WHERE date=(SELECT MAX(date) FROM infosystem_agentratio)")
    public List<AgentRatioModel> selectAgentRatioCount();

    @Select("SELECT * FROM infosystem_arearatio WHERE date=(SELECT MAX(date) FROM infosystem_arearatio)")
    public List<AreaRatioModel> selectAreaRatioCount();

    @Select("SELECT * FROM infosystem_industryratio WHERE date=(SELECT MAX(date) FROM infosystem_industryratio)")
    public List<IndustryRatioModel> selectIndustryRatioCount();
}
