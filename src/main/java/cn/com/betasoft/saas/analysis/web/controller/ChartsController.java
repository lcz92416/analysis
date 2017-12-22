package cn.com.betasoft.saas.analysis.web.controller;

import cn.com.betasoft.saas.analysis.model.*;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import cn.com.betasoft.saas.analysis.service.PGSQLBaseService;
import cn.com.betasoft.saas.analysis.web.model.AgentRatioWebModel;
import org.omg.CORBA.Request;
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
    @Autowired
    private PGSQLBaseService pgsqlBaseService;

    @Autowired
    private MySqlBaseService mySqlBaseService;

    @RequestMapping("/chartIndex")
    public ModelAndView chartIndex() {
        ModelAndView view =new ModelAndView("charts");
//        RegisterCount registersCount=pgsqlBaseService.selectRegistersCount();
//        Long result=mySqlBaseService.insertRegistersCount(registersCount);
//        view.addObject("registersCount",registersCount);
        return view;
    }

    @RequestMapping(value = "/getRegisterCount" ,method = RequestMethod.GET)
    @ResponseBody
    public List<RegisterCountModel> getRegisterCount(){
        List<RegisterCountModel> list= mySqlBaseService.selectRegistersCount();
        return list;
    }

    @RequestMapping(value = "/getProblemTypeCount" ,method = RequestMethod.GET)
    @ResponseBody
    public List<ProblemTypeCountModel> getProblemTypeCount(){
        List<ProblemTypeCountModel> list= mySqlBaseService.selectProblemTypeCount();
        return list;
    }

    @RequestMapping(value = "/getITDepartmentModel" ,method = RequestMethod.GET)
    @ResponseBody
    public List<ITDepartmentModel> getITDepartmentModel(){
        List<ITDepartmentModel> list= mySqlBaseService.selectITDepartmentCount();
        return list;
    }

    @RequestMapping(value = "/getProductTypeRatio" ,method = RequestMethod.GET)
    @ResponseBody
    public List<ProductTypeRatioModel> getProductTypeRatio(){
        List<ProductTypeRatioModel> list= mySqlBaseService.selectProductTypeRatioCount();
        return list;
    }

    @RequestMapping(value = "/getAgentRatio" ,method = RequestMethod.GET)
    @ResponseBody
    public List<AgentRatioModel> getAgentRatio(){
        List<AgentRatioModel> list= mySqlBaseService.selectAgentRatioCount();
        return list;
    }

    @RequestMapping(value = "/getAreaRatio" ,method = RequestMethod.GET)
    @ResponseBody
    public List<AreaRatioModel> getAreaRatio(){
        List<AreaRatioModel> list= mySqlBaseService.selectAreaRatioCount();
        return list;
    }

    @RequestMapping(value = "/getIndustryRatio" ,method = RequestMethod.GET)
    @ResponseBody
    public List<IndustryRatioModel> getIndustryRatio(){
        List<IndustryRatioModel> list= mySqlBaseService.selectIndustryRatioCount();
        return list;
    }

}
