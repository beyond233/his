package com.beyond233.his.config;


import com.beyond233.his.component.MyFilter;
import com.beyond233.his.component.MyListener;
import com.beyond233.his.component.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Collections;

/**
 * <p>项目文档: 使用JavaConfig方式来配置web三大组件：servlet,filter,listener</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-19 21:16
 */
//@Configuration
public class WebComponentConfig {
    /**
     * 将自定义servlet加入容器
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean<MyServlet> servletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myservlet");
        return servletRegistrationBean;
    }

    /**
     * 将自定义filter加入容器
     */
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/myservlet"));
        return filterRegistrationBean;
    }

    /**
     * 将自定义listener加入容器
     */
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return listenerRegistrationBean;
    }
}
