package cn.com.betasoft.saas.analysis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/charts")
public class ChartsController {

    @RequestMapping("/chartIndex")
    public String line() {
        return "charts";
    }

}
