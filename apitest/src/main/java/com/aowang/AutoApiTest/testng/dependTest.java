package com.aowang.AutoApiTest.testng;

import org.testng.annotations.Test;

public class dependTest {
    //该类主要是学习测试方法之间的依赖关系,被依赖的方法回先执行，当被依赖的方法异常，责无法继续执行下去。
    @Test
    public  void zhuyao(){
        System.out.println("这是主方法");
//        throw  new RuntimeException();   模拟异常情况下的操作
    }
    @Test(dependsOnMethods = "zhuyao")
    public  void yilai(){
        System.out.println("这是以来方法");
    }
}
