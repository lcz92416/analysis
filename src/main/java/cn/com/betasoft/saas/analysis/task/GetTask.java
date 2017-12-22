package cn.com.betasoft.saas.analysis.task;

import cn.com.betasoft.saas.analysis.model.ITDepartmentModel;
import cn.com.betasoft.saas.analysis.model.ProblemTypeCountModel;
import cn.com.betasoft.saas.analysis.model.RegisterCountModel;
import cn.com.betasoft.saas.analysis.service.MySqlBaseService;
import cn.com.betasoft.saas.analysis.service.PGSQLBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * created by lichenzhe on 2017/12/18
 */
@Component
public class GetTask {
    private ScheduledExecutorService scheduledExecutorService;
    @Autowired
    private PGSQLBaseService pgsqlBaseService;

    @Autowired
    private MySqlBaseService mySqlBaseService;

    @PostConstruct
    public void getInfo() {
//        long oneDay = 24 * 60 * 60 * 1000;
//        long initDelay  = getTimeMillis("16:38:00") - System.currentTimeMillis();
//        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
//        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleAtFixedRate(new dataAnalysisStart(), initDelay, oneDay, TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public class dataAnalysisStart implements Runnable {

        @Override
        public void run() {
            System.out.println(">>>>>>>start analysis---------------------");
            RegisterCountModel registersCount = pgsqlBaseService.selectRegistersCount();
            mySqlBaseService.insertRegistersCount(registersCount);
            List<ProblemTypeCountModel> problemTypeCountModel = pgsqlBaseService.selectProblemTypeCount();
            mySqlBaseService.insertProblemTypeCount(problemTypeCountModel);
            List<ITDepartmentModel> iTDepartmentModel = pgsqlBaseService.selectITDepartmentCount();
            mySqlBaseService.insertITDepartment(iTDepartmentModel);
        }
    }
}
