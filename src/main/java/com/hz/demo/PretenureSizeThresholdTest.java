package com.hz.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Classname AllocationTest
 * @Description TODO
 * @Date 2019-05-16 06:11
 * @Created by hzong
 */
public class PretenureSizeThresholdTest {
    private static final int _1MB = 1024 * 1024;


    /**
     * 新生代MinorGC
     * VM参数：-verbose:gc -Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
     * <pre>
     * 注：PretenureSizeThreshold单位是bit,参数只对Serial和ParNew 两款收集器有效，Parallel Scavenge收集器不认识这个参数
     * 1.7jdk默认垃圾收集器为   Parallel Scavenge（新生代）+Parallel Old（老年代） ，PretenureSizeThreshol在jdk1.7未指定垃圾收集器时未生效
     * </pre>
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation1;
        allocation1 = new byte[4 * _1MB];//出现一次Minor GC
        try {
            TimeUnit.SECONDS.sleep(111111111L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
