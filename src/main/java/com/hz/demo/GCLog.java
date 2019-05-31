package com.hz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GCLog
 * @Description TODO
 * @Date 2019-05-14 06:10
 * @Created by hzong
 */
public class GCLog {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>(10);
        for (int i = 0; i < 1000; i++) {
            list.add("123123");
        }

        System.gc();
    }
}
