package cn.com.betasoft.saas.analysis.listener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.com.betasoft.saas.analysis.model.SysUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


/**
 * created by lichenzhe on 2017/12/15
 */
public class JobCompletionNotificationListener{
//        extends JobExecutionListenerSupport {
    private static final String PERSON_SQL = "SELECT personName, personAge,personSex FROM Person";

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        if(this.jdbcTemplate==null){
            this.jdbcTemplate = jdbcTemplate;
        }
    }

//    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB 执行完成!");
            List<SysUserModel> results = jdbcTemplate.query(PERSON_SQL, new RowMapper<SysUserModel>() {
                @Override
                public SysUserModel mapRow(ResultSet rs, int row) throws SQLException {
                    return new SysUserModel();
                }
            });
            log.info("入库条数---------"+results.size());
            for (SysUserModel sysUserModel : results) {
                log.info("新增 <" + sysUserModel.getUsername() + "> 成功!!!!!");
            }

        }
    }

    /* (non-Javadoc)
     * @see org.springframework.batch.core.listener.JobExecutionListenerSupport#beforeJob(org.springframework.batch.core.JobExecution)
     */
//    @Override
    public void beforeJob(JobExecution jobExecution) {
        // TODO Auto-generated method stub
//        super.beforeJob(jobExecution);
    }
}
