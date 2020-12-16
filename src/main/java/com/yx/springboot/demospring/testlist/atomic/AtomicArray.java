package com.yx.springboot.demospring.testlist.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArray {

    static AtomicIntegerArray array = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int k=0;k<10000;k++){
                array.getAndIncrement(k % array.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads = new Thread[10];
        for(int i=0; i<10; i++){
            threads[i] = new Thread(new AddThread());
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
        for(int i=0;i<10;i++){
            threads[i].join();
        }
        System.out.println(array);
    }
}
