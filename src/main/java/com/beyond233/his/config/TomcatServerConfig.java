package com.beyond233.his.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Primary;

/**
 * <p>项目文档:  使用JavaConfig的方式来配置服务器
 * 继承ServerProperties类，调用父类的setter方法来修改Tomcat服务器的各项配置</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-19 20:59
 */
//@Component  //将我们自定义的配置类加入容器，告诉SpringBoot使用我们自定义的类来初始化Tomcat服务器
@Primary //原本容器中还有一个自动配置的ServerProperties类的bean用来初始化Tomcat服务器，
// 标注这个注解告诉SpringBoot使用我们自定义的这个服务器配置类的bean来初始化Tomcat服务器
public class TomcatServerConfig extends ServerProperties {
    public TomcatServerConfig() {
        super.setPort(8088);
    }
}
