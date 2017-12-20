package cn.com.betasoft.saas.analysis.web.controller;

import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import cn.com.betasoft.saas.analysis.service.PGSQLBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

}
