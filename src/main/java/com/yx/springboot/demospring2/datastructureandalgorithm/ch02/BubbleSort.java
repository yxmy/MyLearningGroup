package com.yx.springboot.demospring2.datastructureandalgorithm.ch02;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort (int [] arr ){
        int tmp = 0;
        for(int i = 0; i < arr.length -1; i ++ ){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

}