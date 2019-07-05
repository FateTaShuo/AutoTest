package com.aowang.AutoApiTest.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class groupsOnClass2 {
    public void student(){
        System.out.println("这是：groupsOnClass12,student");
    }
    public void student2(){
        System.out.println("这是：groupsOnClass12,student2");
    }
}
