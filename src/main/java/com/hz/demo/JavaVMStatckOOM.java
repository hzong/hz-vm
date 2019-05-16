package com.hz.demo;

/**
 * @Classname JavaVMStatckOF
 * @Description TODO
 * @Date 2019-04-03 07:39
 * @Created by hzong
 */
public class JavaVMStatckOOM {
    private int stackLength = 1;


    public void dotStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dotStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        /**
         * VM设置：-Xss2M
         */
        JavaVMStatckOOM of = new JavaVMStatckOOM();
        of.stackLeakByThread();
    }
}
