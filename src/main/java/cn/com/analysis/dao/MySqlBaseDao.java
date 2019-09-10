package cn.com.analysis.dao;

import cn.com.analysis.model.AgentRatioModel;
import cn.com.analysis.model.AreaRatioModel;
import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.IndustryRatioModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.ProductTypeRatioModel;
import cn.com.analysis.model.RegisterCountModel;
import cn.com.betasoft.saas.analysis.model.*;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */
public interface MySqlBaseDao {
    public List<RegisterCountModel> selectRegistersCount();
    public String insertRegistersCount(RegisterCountModel  registerCountModel);
    public List<ProblemTypeCountModel> selectProblemTypeCount();
    public String insertProblemTypeCount(ProblemTypeCountModel problemTypeCountModel);
    public List<ITDepartmentModel> selectITDepartmentCount();
    public String insertITDepartment(ITDepartmentModel itDepartmentModel);
    public List<ProductTypeRatioModel> selectProductTypeRatioCount();
    public List<AgentRatioModel> selectAgentRatioCount();
    public List<AreaRatioModel> selectAreaRatioCount();
    public List<IndustryRatioModel> selectIndustryRatioCount();
    public String getCollectionTime();

}
