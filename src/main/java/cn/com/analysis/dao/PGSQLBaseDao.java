package cn.com.analysis.dao;

import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.RegisterCountModel;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */
public interface PGSQLBaseDao {
    public RegisterCountModel selectRegistersCount();

    public List<ProblemTypeCountModel> selectProblemTypeCount();

    public List<ITDepartmentModel> selectITDepartmentCount();
}
