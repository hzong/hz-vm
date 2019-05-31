package com.hz.demo;

/**
 * @Classname JavaVMStatckOF
 * @Description TODO
 * @Date 2019-04-03 07:39
 * @Created by hzong
 */
public class JavaVMStatckOF {
    private int stackLength = 1;


    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStatckOF of = new JavaVMStatckOF();
        try {
            /**
             * -Xss160k：设置栈的容量 如果超出则会抛StackOverflowError
             * ----------------------------------------------------
             * 总结：当线程执行栈的深度超过虚拟机栈的深度则会抛StackOverflowError异常
             * 解决版本是：将设置栈的容量。
             */
            of.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + of.stackLength);
            throw e;
        }
    }
}
