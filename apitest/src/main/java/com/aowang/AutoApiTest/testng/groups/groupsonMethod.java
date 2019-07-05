package com.aowang.AutoApiTest.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupsonMethod {
    //该类主要是使用groups组来区分不同的套件,在标签，beforegroups与aftergroups添加新的标签，用来在该组中之前与之后运行相应的方法

    @Test(groups = "groups1")
    public  void  groups1(){
        System.out.println("这是：组1111");
    }
    @Test(groups = "groups2")
    public void groups2(){
        System.out.println("这是：组2222");
    }

    @BeforeGroups("groups1")
    public void befeoGroups(){
        System.out.println("这是:BeforeGroups");
    }
    @AfterGroups("groups1")
    public void afterGroups(){
        System.out.println("这是:AfterGroups");
    }
}
