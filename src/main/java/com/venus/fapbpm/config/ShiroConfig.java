package com.venus.fapbpm.config;


import com.venus.fapbpm.dto.UserRole;
import com.venus.fapbpm.dto.UserWithRoles;
import com.venus.fapbpm.entity.Role;
import com.venus.fapbpm.entity.User;
import com.venus.fapbpm.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;


@Configuration
public class ShiroConfig {
     class ShiroRealm extends AuthorizingRealm {
        @Autowired
        private UserService userService;

        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
            Set<String> roles = new HashSet<String>();
            for (UserRole role : userService.userRoles(String.valueOf(primaryPrincipal))) {
                roles.add(role.getRoleName());
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
            return simpleAuthorizationInfo;
        }


        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            String username = token.getUsername();
            User user = userService.getUserByUsername(username);
            if (user == null) {
                throw new UnknownAccountException("用户不存在");
            }
            Object password = user.getPassword();
            ByteSource salt = ByteSource.Util.bytes(username);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, salt, getName());
            return info;
        }
    }
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "1234";
        Object salt = ByteSource.Util.bytes("zx");
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt);
        System.out.println(result);
    }


    /*
    配置LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
    负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
    主要是AuthorizingRealm类的子类，以及EhCacheManager类。
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //配置CacheManager，缓存管理器
    @Bean(name = "ehCacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager() {
        return new EhCacheManager();
    }

    //配置SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }

    //配置 DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }


    //shiroFilter入口来拦截需要安全控制的url
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        Map<String, Filter> filters = new LinkedHashMap<>();
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/");
//        filters.put("logout",null);
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setLoginUrl("/");

        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
        //放行静态文件
        filterChainDefinitionManager.put("/static/**","anon");
        filterChainDefinitionManager.put("/css/**","anon");
        filterChainDefinitionManager.put("/img/**","anon");
        filterChainDefinitionManager.put("/jquery-3.3.1/**","anon");
        filterChainDefinitionManager.put("/js/**","anon");
        filterChainDefinitionManager.put("/plugins/**","anon");


        //.anon可以被匿名访问
        //.authc必须认证(即登陆)
        // /**拦截所有资源
//        filterChainDefinitionManager.put("/login.html", "anon");
        filterChainDefinitionManager.put("/","anon");
        filterChainDefinitionManager.put("/loginValidate","anon");
        filterChainDefinitionManager.put("/admin/**","roles[admin]");
        filterChainDefinitionManager.put("/logout", "logout");
//        filterChainDefinitionManager.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
        return shiroFilterFactoryBean;
    }


    //密码盐
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }

    //ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm，
    //负责用户的认证和权限的处理
    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroRealm shiroRealm() {
        ShiroRealm realm = new ShiroRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }
}
