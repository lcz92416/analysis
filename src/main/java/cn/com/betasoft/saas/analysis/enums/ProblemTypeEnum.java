package cn.com.betasoft.saas.analysis.enums;

/**
 * created by lichenzhe on 2017/12/19
 */
public enum ProblemTypeEnum {
    TOPOLOGY(0,"拓扑管理"),
    NETWORK(1,"网络管理"),
    HOST(2,"主机管理"),
    DB(3,"数据库管理"),
    MIDDLEWARE(4,"中间件管理"),
    STANDARD(5,"标准应用管理"),
    ALARM(6,"告警管理"),
    MONITOR(7,"监控首页"),
    HISTORY(8,"历史数据查看"),
    REPORT(9,"报表管理"),
    USER(10,"用户管理"),
    NOTICE(11,"通知方式"),
    INSPECTION(12,"自动巡检"),
    APPLYVERSION(13,"申请支持被管对象新版本"),
    APPLYUSER(14,"申请修改用户基本信息"),
    OTHER(15,"其他");

    private int index;
    private String type;

    ProblemTypeEnum(int index, String type) {
        this.index = index;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String getType(int index){
        for(ProblemTypeEnum rme: ProblemTypeEnum.values()){
            if(rme.index==index){
                return rme.type;
            }
        }
        return null;
    }
}
