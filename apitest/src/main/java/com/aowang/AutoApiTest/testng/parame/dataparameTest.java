package com.aowang.AutoApiTest.testng.parame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 该类主要是用dataobje的形式进行数据源的导入操作
 */
public class dataparameTest {

    @Test(dataProvider = "data")
    public void get(String name, int age){
        System.out.println("名字："+name+"++++"+"年龄"+age);
    }
    @DataProvider(name = "data")
    public Object[][] getdata(){
        Object[] [] objects=new Object[][]{
                {"zhanghui",10},
                {"lili",18},
                {"ren",20}
        };
        return objects;
    }

    @Test(dataProvider = "methodData")
    public  void test1(String name, int age){
        System.out.println("这是test1"+ name+"----"+age);
    }
    @Test(dataProvider = "methodData")
    public  void test2(String name, int age){
        System.out.println("这是test2"+ name+"----"+age);
    }

    @DataProvider(name = "methodData")
    public  Object[][] methodDateTest(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"test1",20},
                    {"test001",30}
            };
        }else  if(method.getName().equals("test2")){
            result =new Object[][]{
                    {"test2",24},
                    {"test002",34}

            };
        }
        return  result;
    }
}
