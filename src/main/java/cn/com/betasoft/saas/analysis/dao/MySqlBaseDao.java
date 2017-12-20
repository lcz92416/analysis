package cn.com.betasoft.saas.analysis.dao;

import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */
public interface MySqlBaseDao {
    public List<RegisterCountModel> selectRegistersCount();
    public Long insertRegistersCount(RegisterCountModel  registerCountModel);
    public List<ProblemTypeCountModel> selectProblemTypeCount();
    public Long insertProblemTypeCount(ProblemTypeCountModel problemTypeCountModel);
}
