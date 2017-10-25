package com.kh.admin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description: 判断list集合中的元素是否重复
 * @Date: Created in 16:38 2017/7/19
 */
public class CollectionUtils {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        //去掉集合里面重复的元素
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);

       for(Integer i : list){
           System.out.println(i);
       }

//        System.out.println(hasSame(list));
    }
    private static boolean hasSame(List<? extends Object> list)
    {
        if(null == list)
            return false;
        return list.size() == new HashSet<Object>(list).size();
    }

}
