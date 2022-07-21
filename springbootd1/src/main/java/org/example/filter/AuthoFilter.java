package org.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.utils.ThreadLocalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
//@WebFilter({"/test"})
public class AuthoFilter implements Filter {

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //特定路径
        String uri=request.getRequestURI();
        if(uri.contains("/open"))
        {
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("直接放行");
            return;
        }
        //token
        String token = request.getHeader("Authorization");
        log.info("token = {}",token);
        if(StringUtils.hasLength(token)){
            User user = userService.selectToken(token);
            if(user!=null){
                //保存用户信息
                ThreadLocalCache.set(user);
                //放行
                filterChain.doFilter(servletRequest, servletResponse);
                log.info("token认证成功，放行");
            }
        }
        else throw new RuntimeException("认证失败");

    }

    @Override
    public void destroy() {
        ThreadLocalCache.clean();
    }
}