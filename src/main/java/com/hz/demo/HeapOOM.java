package com.hz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main( String[] args )
    {
        /**
         * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
         * -Xmx20m：设置JVM最大可用内存为20M。
         * -Xms20m：设置JVM促使内存为20m。此值可以设置与-Xmx相同，以避免每次垃圾回收完成后JVM重新分配内存。
         * -XX:+HeapDumpOnOutOfMemoryError：让虚拟机在出现内存溢出异常Dump出当前的内存堆转快照以后边进行解析
         * 生成堆文件在：java_pid675.hprof
         * ----------------------------------------------------
         * 总结：当虚拟机需要扩展栈的无法申请足够的内存空间则会抛出 oom
         */


        List<OOMObject> list =new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
