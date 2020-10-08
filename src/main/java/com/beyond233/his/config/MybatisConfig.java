package com.beyond233.his.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>项目文档: mybatis配置</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-23 11:03
 */
@Configuration
@MapperScan(value = "com.beyond233.his.mapper")
public class MybatisConfig {
}
