package cn.com.betasoft.saas.analysis.web.controller;

import cn.com.betasoft.saas.analysis.model.SysUserModel;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import cn.com.betasoft.saas.analysis.service.PGSQLBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestDataSourceController {

    @Autowired
    private MySqlBaseService mySqlBaseService;

    @Autowired
    private PGSQLBaseService pgsqlBaseService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public List<SysUserModel> selectUser() {
        System.out.println("查询第一个数据源");
        return mySqlBaseService.selectUser();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public List<Object> userDetail() {
        System.out.println("查询第二个数据源");
        return pgsqlBaseService.selectUser();
    }

}