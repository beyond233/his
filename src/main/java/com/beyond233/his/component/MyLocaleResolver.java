package com.beyond233.his.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * <p>项目文档: 国际化 </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @date 2020-02-16 20:06
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale;
        //获取页面传递过来的区域信息
        String l = request.getParameter("l");
        //获取session中的locale
        HttpSession session = request.getSession();
        Locale sessionLocale = (Locale) session.getAttribute("locale");
        //判断页面传递过来的区域信息是否为空且不等于空字符串
        //前端传递了有效的区域信息时，那就按照其设置locale
        if (!StringUtils.isEmpty(l) && !"".equals(l)) {
            String[] s = l.split("_");
            //将区域信息封装到locale对象中
            locale = new Locale(s[0], s[1]);
            //将区域信息保存到session中，整个会话期间都是同一种语言
            session.setAttribute("locale", locale);
        } else if (sessionLocale != null) {
            //当前端未传递区域信息且session中有locale时，那就使用session中的locale
            locale = sessionLocale;
        } else  //如果前端未传递区域信息且session中也没有locale时,则默认使用request的请求头中包含的locale
        {
            locale = request.getLocale();
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
