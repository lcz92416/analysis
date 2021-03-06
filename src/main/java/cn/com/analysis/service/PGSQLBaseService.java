package cn.com.analysis.service;

import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.RegisterCountModel;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface PGSQLBaseService {

    /**
     * 提取注册数据
     * @return
     */
    public RegisterCountModel selectRegistersCount();

    /**
     * 提取问题模块
     * @return
     */
    public List<ProblemTypeCountModel> selectProblemTypeCount();

    /**
     * 提取部门信息
     * @return
     */
    public List<ITDepartmentModel> selectITDepartmentCount();
}
