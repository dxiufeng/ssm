package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author dxf
 * @Description 用于加密测试
 */
public class BCryptPasswordEncoderUtil {
    public static String encodePassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);


        return encode;
    }


    public static void main(String[] args) {
        String s = BCryptPasswordEncoderUtil.encodePassword("123");

        //$2a$10$EkubkFY9XsMnHBejMnyWUewYp5GvRz3xrIMvN5Zk0gvRvcE9MtH8C
        //$2a$10$uqvIooRCd7VW1u8tPYnxl.gPinyE4.Fy7HKnPRtEZXULOULmHrGTW
        System.out.println(s);
    }
}


