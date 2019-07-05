package com.aowang.AutoApiTest.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class groupsOnClass1 {

    public void student(){
        System.out.println("这是：groupsOnClass1,student");
    }
    public void student2(){
        System.out.println("这是：groupsOnClass1,student2");
    }
}
