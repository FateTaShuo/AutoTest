package com.aowang.AutoApiTest.testng;

import org.testng.annotations.Test;

public class myexcetion {
    @Test(expectedExceptions = RuntimeException.class)
    public void excetion1(){
        System.out.println("这是一个判断异常的测试");
    }
    //异常方法
    @Test(expectedExceptions = RuntimeException.class)
    public void excetion2(){
        System.out.println("这是一个判断异常的测试");
        throw new  RuntimeException();
    }
}
