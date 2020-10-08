package com.beyond233.his.util;

import java.util.Date;

/**
 * <p>项目文档: 判断某时间是在当前时间之前还是之后，之前返回true，之后返回false</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-13 11:54
 */
public class OutOfDateJudgeUtil {
    public static boolean beforeIfCurrentTime(Date date) {
        return date.before(new Date());
    }
}
