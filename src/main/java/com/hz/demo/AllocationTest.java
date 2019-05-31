package com.hz.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Classname AllocationTest
 * @Description TODO
 * @Date 2019-05-16 06:11
 * @Created by hzong
 */
public class AllocationTest {
    private static final int _1MB = 1024 * 1024;


    /**
     * 新生代MinorGC
     * VM参数：-verbose:gc -Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * [GC [PSYoungGen: 6408K->695K(9216K)] 6408K->4791K(19456K), 0.0057510 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
     * Heap
     * PSYoungGen      total 9216K, used 7110K [0x00000007ff600000, 0x0000000800000000, 0x0000000800000000)
     * eden space 8192K, 78% used [0x00000007ff600000,0x00000007ffc43c70,0x00000007ffe00000)
     * from space 1024K, 67% used [0x00000007ffe00000,0x00000007ffeadc90,0x00000007fff00000)
     * to   space 1024K, 0% used [0x00000007fff00000,0x00000007fff00000,0x0000000800000000)
     * ParOldGen       total 10240K, used 4096K [0x00000007fec00000, 0x00000007ff600000, 0x00000007ff600000)
     * object space 10240K, 40% used [0x00000007fec00000,0x00000007ff000020,0x00000007ff600000)
     * PSPermGen       total 21504K, used 3280K [0x00000007f9a00000, 0x00000007faf00000, 0x00000007fec00000)
     * object space 21504K, 15% used [0x00000007f9a00000,0x00000007f9d343a0,0x00000007faf00000)
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次Minor GC
        try {
            TimeUnit.SECONDS.sleep(11111111L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testAllocation();
    }
}
