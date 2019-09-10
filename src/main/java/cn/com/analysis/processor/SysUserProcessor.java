package cn.com.analysis.processor;

import cn.com.analysis.model.SysUserModel;
import cn.com.analysis.service.PGSQLBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by lichenzhe on 2017/12/15
 */
public class SysUserProcessor implements ItemProcessor<SysUserModel,SysUserModel> {
    private static final Logger log = LoggerFactory.getLogger(SysUserProcessor.class);
    @Autowired
    private PGSQLBaseService pgsqlBaseService;

    @Override
    public SysUserModel process(SysUserModel sysUserModel) throws Exception {
        return null;
    }
}
