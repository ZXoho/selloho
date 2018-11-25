package com.cn.demo.config;

import com.cn.demo.realm.CustomRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
       ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
       //设置securityManager
       shiroFilterFactoryBean.setSecurityManager(securityManager);
       //设置登录页面。默认为web工程目录下"/login.jsp"
       shiroFilterFactoryBean.setLoginUrl("/login");
       //设置无权限时跳转
       shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

       //设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //用户开发权限
       //filterChainDefinitionMap.put("/user/**", "role[user]");
        //商家权限
        //filterChainDefinitionMap.put("/seller/**", "role[seller]");
        //管理员权限
        //filterChainDefinitionMap.put("/manager/**", "role[manager]");
        //开放接口
        filterChainDefinitionMap.put("/sell", "anon");
        //其余接口一律拦截
        //filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("shiro拦截工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }


}
