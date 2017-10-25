package com.kh.admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 所在的包名: com.kh.admin
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:  正则表达式
 * @Date: Created in 21:13 2017/10/16
 */
public class matchingTest {

    /**
     * 回溯法
     * @param args
     */
    public static void main(String[] args) {

        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        if(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println(rs);
    }
}
