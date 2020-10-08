package com.beyond233.his;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 13:13
 */
class Md5Test {
    public static void main(String[] args) {
        String password = "123";
        //1.不加盐和散列次数
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("不加：" + md5Hash);
        //2.加盐，加散列次数
        String salt = "员工管理";
        Md5Hash beyond = new Md5Hash(password, salt, 2);
        System.out.println("加盐加散列：" + beyond);

    }
}
