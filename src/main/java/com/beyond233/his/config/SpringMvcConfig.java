package com.beyond233.his.config;

import com.beyond233.his.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>项目文档: SpringMVC扩展配置 </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @date 2020-02-17 18:10
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    /**
     * 将自定义的区域信息解析器加入容器中,此时会关闭SpringBoot自动配置的LocaleResolver
     * 自定义区域信息解析器方法名必须为：localeResolver ！
     *
     * @return com.beyond233.his.component.MyLocaleResolver
     * @since 2020/3/22 19:52
     */
    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
//    @Bean //以前配置restful的方式
//    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
//        return new HiddenHttpMethodFilter() ;
//    }

    /**
     * //添加自定义视图映射
     *
     * @param registry .
     * @return void
     * @since 2020/3/22 19:55
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/manager").setViewName("manager");
        registry.addViewController("/manager.html").setViewName("manager");
        registry.addViewController("/reset.html").setViewName("reset");
        registry.addViewController("/signup.html").setViewName("signup");
        registry.addViewController("/emp/emplogin.html").setViewName("emp/emplogin");
        registry.addViewController("/emp/admin.html").setViewName("emp/admin");
        registry.addViewController("/map.html").setViewName("map");
        registry.addViewController("/history.html").setViewName("history");
        registry.addViewController("/intro.html").setViewName("intro");

    }

    @Override  //添加自定义拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录拦截器
//        registry.addInterceptor(new MyLoginInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/","/index.html","/login","/assets/**","/webjars/**");

    }
}
