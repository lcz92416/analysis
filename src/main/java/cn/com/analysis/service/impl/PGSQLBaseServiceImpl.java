package cn.com.analysis.service.impl;

import cn.com.analysis.dao.PGSQLBaseDao;
import cn.com.analysis.model.ITDepartmentModel;
import cn.com.analysis.model.ProblemTypeCountModel;
import cn.com.analysis.model.RegisterCountModel;
import cn.com.analysis.service.PGSQLBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

@Service
public class PGSQLBaseServiceImpl implements PGSQLBaseService {

    @Autowired
    private PGSQLBaseDao pgsqlBaseDao;

    @Override
    public RegisterCountModel selectRegistersCount() {
        return pgsqlBaseDao.selectRegistersCount();
    }

    @Override
    public List<ProblemTypeCountModel> selectProblemTypeCount(){
        return pgsqlBaseDao.selectProblemTypeCount();
    }

    @Override
    public List<ITDepartmentModel> selectITDepartmentCount(){
        return pgsqlBaseDao.selectITDepartmentCount();
    }

}
