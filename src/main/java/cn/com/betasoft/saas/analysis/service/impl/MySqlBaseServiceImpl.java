package cn.com.betasoft.saas.analysis.service.impl;

import cn.com.betasoft.saas.analysis.dao.MySqlBaseDao;
import cn.com.betasoft.saas.analysis.enums.ProblemTypeEnum;
import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;
import cn.com.betasoft.saas.analysis.processor.SysUserProcessor;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * created by lichenzhe on 2017/12/11
 */

@Service
public class MySqlBaseServiceImpl implements MySqlBaseService {
    private static final Logger log = LoggerFactory.getLogger(MySqlBaseServiceImpl.class);


    @Autowired
    private MySqlBaseDao mySqlBaseDao;

    @Override
    public List<RegisterCountModel> selectRegistersCount() {
        return mySqlBaseDao.selectRegistersCount();
    }

    @Override
    public Long insertRegistersCount(RegisterCountModel registersCountModel) {
        return mySqlBaseDao.insertRegistersCount(registersCountModel);
    }

    @Override
    public List<ProblemTypeCountModel> selectProblemTypeCount(){
        List<ProblemTypeCountModel> list=mySqlBaseDao.selectProblemTypeCount();
        for(ProblemTypeCountModel problemTypeCountModel : list){
            problemTypeCountModel.setType(ProblemTypeEnum.getType(problemTypeCountModel.getWorkOrderType()));
        }
        return list;
    }

    @Override
    public void insertProblemTypeCount(List<ProblemTypeCountModel> list){
        try{
        List<ProblemTypeCountModel> result=new ArrayList<>();
        if(list != null && list.size()>0) {
            Date date = list.get(0).getAnalysisDate();
            List<Integer> intList=new ArrayList<>();
            for (ProblemTypeCountModel problemTypeCountModel : list) {
                    intList.add(problemTypeCountModel.getWorkOrderType());
            }
            result.addAll(list);
            for (int i = 0; i < 16; i++) {
                if(!intList.contains(i)) {
                    ProblemTypeCountModel countModel = new ProblemTypeCountModel();
                    countModel.setAnalysisDate(date);
                    countModel.setCount(0);
                    countModel.setWorkOrderType(i);
                    result.add(countModel);
                }
            }
            for (ProblemTypeCountModel problemTypeCountModel : result) {
                mySqlBaseDao.insertProblemTypeCount(problemTypeCountModel);
            }
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}