package com.aowang.AutoApiTest.testng;

import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicAnnotation {

//    public void getTime(){
//        String nowtime;
//        Date date =new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        nowtime =dateFormat.format(date.getTime());
//        return nowtime;
//    }
//    String nowtime;
//    Date date =new Date();
//    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//    nowtime =dateFormat.format(date.getTime());
    @Test
    public void  testCase1(){
     System.out.println("这是:test1,11111");
    }

    @BeforeClass
    public void before(){
        System.out.println("这是:BeforeClass");
    }

    @BeforeMethod
    public void beforMethn(){
        System.out.println("这是:BeforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是:AfterMethod");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是：beforeSuite");
    }
    @AfterSuite
    public  void agterSuite(){
        System.out.println("这是：AfterSuite");
    }

    @Test
    public  void  testCase2(){
        System.out.println("这是:test2,22222！");
    }

    @AfterClass
    public  void  after(){
        System.out.println("这是:AfterClass");
    }
}
