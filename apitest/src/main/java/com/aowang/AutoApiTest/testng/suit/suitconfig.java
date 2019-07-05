package com.aowang.AutoApiTest.testng.suit;

import org.testng.annotations.*;
//该类主要是为了测试套件之间的顺序关系：AfterSuite > BeforeTest > AfterTest > BeforeSuite
public class suitconfig {

    @AfterSuite
    public void afterSuite(){
        System.out.println("这是：AfterSuite----001");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是：BeforeSuite----001");
    }
    @BeforeTest
    public void beforeClass(){
        System.out.println("这是：BeforeTest----001");
    }
    @AfterTest
    public void afterClass(){
        System.out.println("这是：AfterTest----001");
    }
}
