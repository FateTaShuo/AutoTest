package com.aowang.AutoApiTest.testng.parame;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameTest {
    //该类主要是测试，参数化的testng

    @Test
    @Parameters({"name","age"})
    public  void getUser(String name, String age){
        System.out.println("名字："+name +"----"+
                "年龄"+age);
    }
}
