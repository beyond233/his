package com.beyond233.his;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-07-10 21:33
 */
public class NullTest {
    public static void main(String[] args) {
        String s=null;
        m2(s);
    }

    public static boolean m2(String s){
        boolean result = false;
        if (!"".equals(s)) {
            result = "233".equals(s);
            if (s!=null) {
                result = true;
            }
        }
        return result;

    }
}
