package com.yx.springboot.demospring.testlist.test;

import com.yx.springboot.demospring.testlist.model.UserDetail;
import com.yx.springboot.demospring.testlist.modelmapper.model.Customer;
import com.yx.springboot.demospring.testlist.modelmapper.model.Name;
import com.yx.springboot.demospring.testlist.modelmapper.model.SourceModel;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    public static int getFileCount(File file) {
        int count = 0;
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                count += getFileCount(file1);
            } else {
                count++;
            }
        }
        return count;
    }

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }
    }

    public UserDetail get() {
        com.yx.springboot.demospring.testlist.model.User user = new com.yx.springboot.demospring.testlist.model.User();
        user.setName("aaa");
        user.setAge(10);
        user.setAddress("北京市");
        return user;
    }

    @Test
    public void test() {
        UserDetail userDetail = get();
        System.out.println(userDetail);
    }

    @Test
    public void nullable() {
        SourceModel model = new SourceModel();
        String firstName = Optional.ofNullable(model).map(SourceModel::getCustomer).map(Customer::getName).map(Name::getFirstName).orElse("");
        System.out.println(firstName);
    }

    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("poi");
        list.add("dsf");
        list.add("abc");
        list.add("oif");

        list.forEach(s -> {
            System.out.print(s + ",");
        });
        list.sort(null);
        System.out.println("----------------------------------");
        list.forEach(s -> {
            System.out.print(s + ",");
        });
    }

    @Test
    public void test3(){
        String name = "1231,444,88,9,";
        String substring = name.substring(0, name.lastIndexOf(","));
        System.out.println(substring);
    }

    @Test
    public void test4(){
        final String filePath = "C:\\aaa";
        File targetZip = new File(filePath);
        final StringBuilder command = new StringBuilder();
        command.append("7za a -tzip ")
                .append(targetZip.getAbsolutePath())
                .append(" ");
        try {
            final Process ps = Runtime.getRuntime().exec(command.toString());
            final BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            final StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            final String result = sb.toString();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}