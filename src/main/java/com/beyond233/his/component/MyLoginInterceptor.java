package com.beyond233.his.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>项目文档: 验证用户是否登录，登录后才可以访问其他页面</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @date 2020-02-16 22:23
 */
public class MyLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user = request.getSession().getAttribute("user");
        System.out.println("拦截器************************************************正在运行");
        if (user == null) {
            //用户未登录，返回登录页面
            request.setAttribute("error", "请先登录");
            String contentType = request.getHeader("Accept");
            System.out.println("contentType设置前:***********************************************" + contentType);
            response.setContentType(contentType == null ? "text/html;charset=utf-8" : contentType + ";charset=utf-8");
            System.out.println("contentType设置后:***********************************************" + response.getContentType());
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            //用户已登录，跳转页面
            System.out.println("用户已经登录");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("方法执行结束################################" + response.getContentType());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("页面渲染完成￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥" + response.getContentType());


    }
}
