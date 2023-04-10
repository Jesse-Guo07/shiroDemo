package com.shirotest;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/*
 * @Author JesseGuo
 * @Description  shiro 使用Md5加密
 * @Date 17:30 2023/4/10
 **/
public class ShiroMD5 {
    public static void main(String[] args) {
        //密码明文
        String password = "guo";

        //使用MD5加密
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("md5hash值 = " + md5Hash);

        //加盐salt：带盐的Md5加密
        Md5Hash md5Hash1 = new Md5Hash(password, "salt");
        System.out.println("带盐的md5hash1值 = " + md5Hash1);

        //加盐salt：带盐的Md5加密，迭代3次
        Md5Hash md5Hash2 = new Md5Hash(password, "salt", 3);
        System.out.println("带盐的md5hash2值，并且迭代3次 = " + md5Hash2);

        //使用父类加密
        SimpleHash simpleHash = new SimpleHash("MD5",
                password,
                "salt",
                3);
        System.out.println("父类带盐的md5hash2值，并且迭代3次 = " + simpleHash); //与md5Hash2相同
    }
}
