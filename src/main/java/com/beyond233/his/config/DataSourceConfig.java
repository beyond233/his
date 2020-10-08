package com.beyond233.his.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>项目文档: 数据源配置</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-22 16:07
 */
@Configuration
public class DataSourceConfig {
    //初始化druid数据源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     *配置druid监控:
     *             1.配置一个管理后台的servlet
     *             2.配置一个用于监控的filter
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        //注册servlet，并设置访问该servlet的路径为: /druid/*
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //设置初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "1");
        //默认允许所有访问
        initParams.put("allow", "");
        registrationBean.setInitParameters(initParams);
        //
        return registrationBean;
    }

    /**
     *配置druid监控:
     *             1.配置一个管理后台的servlet
     *             2.配置一个用于监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
        //设置要添加的filter
        registrationBean.setFilter(new WebStatFilter());
        //设置初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        registrationBean.setInitParameters(initParams);
        //设置要拦截的路径
        registrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return registrationBean;

    }
}

