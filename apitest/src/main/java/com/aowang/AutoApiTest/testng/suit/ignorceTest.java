package com.aowang.AutoApiTest.testng.suit;

import org.testng.annotations.Test;

import javax.sound.midi.SysexMessage;
//忽略测试，在注解中添加，enable，
public class ignorceTest {

    @Test
    public  void ignorce(){
        System.out.println("这是：ignorce1");
    }
    @Test
    public  void ignorce2(){
        System.out.println("这是：ignorce2");
    }
}
