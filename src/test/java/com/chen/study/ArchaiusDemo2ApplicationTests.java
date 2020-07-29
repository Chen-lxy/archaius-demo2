package com.chen.study;

import com.chen.study.demo.Demo1;
import com.chen.study.mapper.UpdateMapper;
import com.chen.study.service.UpdateService;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class ArchaiusDemo2ApplicationTests {
    @Autowired
    Demo1 demo1;

    @Autowired
    UpdateService service;

    @Test
    void contextLoads() {
        DynamicStringProperty name = DynamicPropertyFactory
                .getInstance().getStringProperty("name", "aaaa");
        System.out.println(name);
        System.out.println(name.getValue() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        // 模拟更改配置信息
        service.updateName("陈亮");
        //设置回调
        name.addCallback(() -> {
            System.out.println("name callback, new value: " + name.get());
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DynamicStringProperty name1 = DynamicPropertyFactory
                .getInstance().getStringProperty("name", "aaaa");
        System.out.println(name1);
        System.out.println(name1.getValue() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void test1(){
        Properties prop = demo1.getProp();
        System.out.println(prop);
    }

}
