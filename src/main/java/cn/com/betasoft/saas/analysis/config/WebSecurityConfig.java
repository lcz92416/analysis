package cn.com.betasoft.saas.analysis.config;

import cn.com.betasoft.saas.analysis.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * created by lichenzhe on 2017/12/11
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**","/img/**").permitAll()  //不需要被保护
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("USER");
//    }

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证

    }
}

