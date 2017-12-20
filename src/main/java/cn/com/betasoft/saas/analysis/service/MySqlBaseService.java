package cn.com.betasoft.saas.analysis.service;


import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

public interface MySqlBaseService {

    /**
     * 提取注册数据
     * @return
     */
    public List<RegisterCountModel> selectRegistersCount();

    /**
     * 插入注册数据
     * @param registersCountModel
     * @return
     */
    public Long insertRegistersCount(RegisterCountModel registersCountModel);

    /**
     * 提取问题模块
     * @return
     */
    public List<ProblemTypeCountModel> selectProblemTypeCount();

    /**
     * 插入问题模块
     * @param list
     * @return
     */
    public void insertProblemTypeCount(List<ProblemTypeCountModel> list);
}
