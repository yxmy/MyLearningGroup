package com.yx.springboot.demospring2.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoClass {

    public static void main(String[] args) {
//        File file = new File("/home/pc-yx/gitProject");
//        Map<String, Integer> map = new HashMap<>();
//        for(File file1 : file.listFiles()){
//            String businessDateFileName = file1.getName();
//            if (file1.isDirectory()){
//                for(File file2 : file1.listFiles()){
//                    String cinemaCodeFileName = file2.getName();
//                    if(file2.isDirectory()){
//                        map.put(businessDateFileName + "," + cinemaCodeFileName, getFileCount(file2));
//                    }
//                }
//            }
//        }
//
//        for(Map.Entry<String, Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + "::::::" + entry.getValue());
//        }
        List<User> userList = new ArrayList<>();
        User user1 = new User("张三", 20);
        User user2 = new User("李四", 21);
        User user3 = new User("王五", 22);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Map<Integer, User> map = new HashMap<>();
        map.put(1, user1);
        map.put(2, user2);
        map.put(3, user3);
        user1.name = "小红";
        user2.name = "小白";
        user3.name = "小明";
        System.out.println(userList.get(1).name);
        System.out.println(map.get(1).name);

    }

    public static int getFileCount(File file){
        int count = 0;
        for(File file1 : file.listFiles()){
            if(file1.isDirectory()){
                count += getFileCount(file1);
            }else{
                count++;
            }
        }
        return count;
    }

    static class User{
        String name;
        int age;
        public User(String name, int age){
            this.age = age;
            this.name = name;
        }
    }
}
