package cn.com.betasoft.saas.analysis.service.impl;

import cn.com.betasoft.saas.analysis.dao.MySqlBaseDao;
import cn.com.betasoft.saas.analysis.enums.ProblemTypeEnum;
import cn.com.betasoft.saas.analysis.model.*;
import cn.com.betasoft.saas.analysis.processor.SysUserProcessor;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import cn.com.betasoft.saas.analysis.utils.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String insertRegistersCount(RegisterCountModel registersCountModel) {
        return mySqlBaseDao.insertRegistersCount(registersCountModel);
    }

    @Override
    public List<ProblemTypeCountModel> selectProblemTypeCount(){
        List<ProblemTypeCountModel> list=mySqlBaseDao.selectProblemTypeCount();
//        for(ProblemTypeCountModel problemTypeCountModel : list){
//            problemTypeCountModel.setType(ProblemTypeEnum.getType(problemTypeCountModel.getWorkOrderType()));
//        }
        return list;
    }

    @Override
    public void insertProblemTypeCount(List<ProblemTypeCountModel> list){
        try{
//        List<ProblemTypeCountModel> result=new ArrayList<>();
//        if(list != null && list.size()>0) {
//            Date date = list.get(0).getAnalysisDate();
//            List<Integer> intList=new ArrayList<>();
//            for (ProblemTypeCountModel problemTypeCountModel : list) {
//                    intList.add(problemTypeCountModel.getWorkOrderType());
//            }
//            result.addAll(list);
//            for (int i = 0; i < 16; i++) {
//                if(!intList.contains(i)) {
//                    ProblemTypeCountModel countModel = new ProblemTypeCountModel();
//                    countModel.setAnalysisDate(date);
//                    countModel.setCount(0);
//                    countModel.setWorkOrderType(i);
//                    result.add(countModel);
//                }
//            }
//            for (ProblemTypeCountModel problemTypeCountModel : result) {
//                mySqlBaseDao.insertProblemTypeCount(problemTypeCountModel);
//            }
//        }
        }catch (Exception e){
            log.info("insertProblemTypeCount error:"+e);
        }
    }

    @Override
    public List<ITDepartmentModel> selectITDepartmentCount(){
        List<ITDepartmentModel> list=mySqlBaseDao.selectITDepartmentCount();
//        Map<String,String> typeMap= ConfigUtils.readTxtForMap("ITDepartmentConfig");
//        for(ITDepartmentModel iTDepartmentModel : list){
//            iTDepartmentModel.setType(typeMap.get(iTDepartmentModel.getItdepartment()==null?"":iTDepartmentModel.getItdepartment()));
//        }
        return list;
    }

    @Override
    public void insertITDepartment(List<ITDepartmentModel> list){
        try{
                for (ITDepartmentModel iTDepartmentModel : list) {
                    mySqlBaseDao.insertITDepartment(iTDepartmentModel);
                }
        }catch (Exception e){
            log.info("insertITDepartment error:"+e);
        }
    }

    @Override
    public List<ProductTypeRatioModel> selectProductTypeRatioCount(){
        return mySqlBaseDao.selectProductTypeRatioCount();
    }

    @Override
    public List<AgentRatioModel> selectAgentRatioCount(){
        return mySqlBaseDao.selectAgentRatioCount();
    }


    @Override
    public List<AreaRatioModel> selectAreaRatioCount(){
        return mySqlBaseDao.selectAreaRatioCount();
    }

    @Override
    public List<IndustryRatioModel> selectIndustryRatioCount(){
        return mySqlBaseDao.selectIndustryRatioCount();
    }

    @Override
    public String getCollectionTime(){
        return mySqlBaseDao.getCollectionTime();
    }
}