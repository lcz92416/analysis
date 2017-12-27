package cn.com.betasoft.saas.analysis.web.controller;

import cn.com.betasoft.saas.analysis.model.*;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import cn.com.betasoft.saas.analysis.service.PGSQLBaseService;
import cn.com.betasoft.saas.analysis.web.model.AgentRatioWebModel;
import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/charts")
public class ChartsController {
    private static final Logger log = LoggerFactory.getLogger(ChartsController.class);

    @Autowired
    private PGSQLBaseService pgsqlBaseService;

    @Autowired
    private MySqlBaseService mySqlBaseService;

    @RequestMapping("/chartIndex")
    public ModelAndView chartIndex() {
        ModelAndView view = new ModelAndView("charts");
        try {
            String time = mySqlBaseService.getCollectionTime();
            view.addObject("collectionTime", time);
        } catch (Exception e) {
            log.info("chartIndex error:" + e);
        }
//        RegisterCount registersCount=pgsqlBaseService.selectRegistersCount();
//        Long result=mySqlBaseService.insertRegistersCount(registersCount);
//        view.addObject("registersCount",registersCount);
        return view;
    }

    @RequestMapping(value = "/getRegisterCount", method = RequestMethod.GET)
    @ResponseBody
    public List<RegisterCountModel> getRegisterCount() {
        List<RegisterCountModel> list = new ArrayList<>();
        try {
            list = mySqlBaseService.selectRegistersCount();
        } catch (Exception e) {
            log.info("getRegisterCount error:" + e);
        }
        return list;
    }

    @RequestMapping(value = "/getProblemTypeCount", method = RequestMethod.GET)
    @ResponseBody
    public List<ProblemTypeCountModel> getProblemTypeCount() {
        List<ProblemTypeCountModel> list = new ArrayList<>();
        try {
            list = mySqlBaseService.selectProblemTypeCount();
        } catch (Exception e) {
            log.info("getProblemTypeCount error:" + e);
        }
        return list;
    }

    @RequestMapping(value = "/getITDepartmentModel", method = RequestMethod.GET)
    @ResponseBody
    public List<ITDepartmentModel> getITDepartmentModel() {
        List<ITDepartmentModel> list = new ArrayList<>();

        try {
            list = mySqlBaseService.selectITDepartmentCount();
        } catch (Exception e) {
            log.info("getITDepartmentModel error:" + e);
        }
        return list;
    }

    @RequestMapping(value = "/getProductTypeRatio", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductTypeRatioModel> getProductTypeRatio() {
        List<ProductTypeRatioModel> list = new ArrayList<>();

        try {
            list = mySqlBaseService.selectProductTypeRatioCount();
        } catch (Exception e) {
            log.info("getProductTypeRatio error:" + e);
        }
        return list;
    }

    @RequestMapping(value = "/getAgentRatio", method = RequestMethod.GET)
    @ResponseBody
    public List<AgentRatioModel> getAgentRatio() {
        List<AgentRatioModel> list = new ArrayList<>();

        try {
            list = mySqlBaseService.selectAgentRatioCount();
        } catch (Exception e) {
            log.info("getAgentRatio error:" + e);
        }
        return list;
    }

    @RequestMapping(value = "/getAreaRatio", method = RequestMethod.GET)
    @ResponseBody
    public List<AreaRatioModel> getAreaRatio() {
        List<AreaRatioModel> list = new ArrayList<>();
        try {
            list = mySqlBaseService.selectAreaRatioCount();
        } catch (Exception e) {
            log.info("getAreaRatio error:" + e);
        }
        return list;
    }

    @RequestMapping(value = "/getIndustryRatio", method = RequestMethod.GET)
    @ResponseBody
    public List<IndustryRatioModel> getIndustryRatio() {
        List<IndustryRatioModel> list = new ArrayList<>();

        try {
            list = mySqlBaseService.selectIndustryRatioCount();
        } catch (Exception e) {
            log.info("getIndustryRatio error:" + e);
        }
        return list;
    }

}
