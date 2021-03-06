package com.hz.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Classname AllocationTest
 * @Description TODO
 * @Date 2019-05-16 06:11
 * @Created by hzong
 */
public class TenuringThresholdTest {
    private static final int _1MB = 1024 * 1024;


    /**
     * 长期存活的对象进入老年代
     * VM参数：-verbose:gc -Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+UseParNewGC
     * -XX:+PrintTenuringDistribution
     * <pre>
     * </pre>
     */
    public static void tesTenuringDistribution() {
        byte[] allocation1,allocation2,allocation3;
//        allocation1 = new byte[_1MB/4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
//        allocation3 = null;
//        allocation3 = new byte[4 * _1MB];
//        try {
//            TimeUnit.SECONDS.sleep(3L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) {
        tesTenuringDistribution();
    }
}
