package httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class testDemoClient {

    @Test
    public void httpclient() throws IOException {
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient getclient= new DefaultHttpClient();
       HttpResponse response= getclient.execute(get);
       result = EntityUtils.toString(response.getEntity(),"utf-8");
       System.out.println("这是百度的返回结果："+result);
    }
}
