package com.hz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M;
 * JDK8中metaspace代替permsize，因此在许多我们设置permsize大小的地方同样需要修改配置为metaspace
 *
 * @Classname RuntimeConstantPoolOOM
 * @Description TODO
 * @Date 2019-04-08 07:23
 * @Created by hzong
 */
public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {
        //使用List保持着常量池引用，避免FullGC回收常量池行为
        List<String> list = new ArrayList<>();
        //10mb的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
