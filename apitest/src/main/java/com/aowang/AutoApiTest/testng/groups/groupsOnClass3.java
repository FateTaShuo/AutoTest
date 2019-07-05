package com.aowang.AutoApiTest.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupsOnClass3 {
    public void teacher(){
        System.out.println("这是：groupsOnClass3,teacher");
    }
    public void teacher2(){
        System.out.println("这是：groupsOnClass3,teacher2");
    }
}
