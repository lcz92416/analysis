package cn.com.betasoft.saas.analysis.dao;

import cn.com.betasoft.saas.analysis.model.*;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */
public interface MySqlBaseDao {
    public List<RegisterCountModel> selectRegistersCount();
    public Long insertRegistersCount(RegisterCountModel  registerCountModel);
    public List<ProblemTypeCountModel> selectProblemTypeCount();
    public Long insertProblemTypeCount(ProblemTypeCountModel problemTypeCountModel);
    public List<ITDepartmentModel> selectITDepartmentCount();
    public Long insertITDepartment(ITDepartmentModel itDepartmentModel);
    public List<ProductTypeRatioModel> selectProductTypeRatioCount();
    public List<AgentRatioModel> selectAgentRatioCount();
    public List<AreaRatioModel> selectAreaRatioCount();
    public List<IndustryRatioModel> selectIndustryRatioCount();

}
