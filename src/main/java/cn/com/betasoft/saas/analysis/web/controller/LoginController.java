package cn.com.betasoft.saas.analysis.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            return "index";
        }
    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//    {
//        Assert.notNull(request, "HttpServletRequest required");
//            HttpSession session = request.getSession(false);
//            if (session != null) {
//                session.invalidate(); //使当前会话失效
//            }
//        SecurityContextHolder.clearContext(); //清空安全上下文
//    }
}
