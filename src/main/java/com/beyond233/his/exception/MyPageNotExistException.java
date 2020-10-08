package com.beyond233.his.exception;

/**
 * <p>项目文档: 自定义异常：访问页面不存在时抛出</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-19 17:16
 */
public class MyPageNotExistException extends RuntimeException {
    public MyPageNotExistException() {
        super("发生异常：页面不存在");
    }
}
