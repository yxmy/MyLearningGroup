package com.yx.springboot.demospring.controller;

import com.yx.springboot.demospring.testlist.model.Person;
import com.yx.springboot.demospring.testlist.service.AbstractBaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author seeyon_yuanxin
 * @date 2020-12-16 17:47
 */
@RestController
public class DemoController {

    @Resource(name = "serviceA")
    private AbstractBaseService serviceA;

    @Resource(name = "serviceB")
    private AbstractBaseService serviceB;

    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("aa", 11);
        List<Person> list = new ArrayList<>();
        list.add(new Person("bb",22));
        list.add(new Person("cc",33));
        list.add(new Person("dd",44));
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", list);
        return "index";
    }

    @GetMapping("a")
    public String findA() {
        return serviceA.sayHello();
    }

    @GetMapping("b")
    public String findB() {
        return serviceB.sayHello();
    }
}
