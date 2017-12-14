package cn.com.betasoft.saas.analysis.provider;

public class SysUserByMySqlProvider {
    public String findSysByUserName(String username){
        return "select u.*,r.roleName from Sys_User u LEFT JOIN sys_role_user sru on u.id= sru.Sys_User_id LEFT JOIN Sys_Role r on sru.Sys_Role_id=r.id where username= #{username}";
    }
}
