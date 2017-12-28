package cn.com.betasoft.saas.analysis.service;

import cn.com.betasoft.saas.analysis.mapper.SysUserByMySqlMapper;
import cn.com.betasoft.saas.analysis.model.SysRoleModel;
import cn.com.betasoft.saas.analysis.model.SysUserModel;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomUserService implements UserDetailsService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CustomUserService.class);

    @Autowired
    SysUserByMySqlMapper sysuserByMySqlMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) { //重写loadUserByUsername 方法获得 userdetails 类型用户
        SysUserModel user = new SysUserModel();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        try {
            user = sysuserByMySqlMapper.findSysByUserName(userName);
            if (user == null) {
                throw new UsernameNotFoundException("用户名不存在");
            }
            // 用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
            for (SysRoleModel role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        } catch (Exception e) {
            log.info("登录错误："+ e);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
