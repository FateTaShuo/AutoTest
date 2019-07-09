package httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class getCookiese {
   private String url;
   private ResourceBundle bundle;
    //将获取的到cookie那进行存储
   private CookieStore cookieStore;

    //在执行测试是需要读取动态配置的url路径
    @BeforeClass
    public void geturl(){

         //通过bundle对象去配置文件中读取文件，然后通过配置文件的路径去读取相应key 的value
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
        System.out.println("这是配置文件的url路径："+url);

    }

    @Test
    public void getCkooies() throws IOException {
        String result;
        String testurl;
        String geturl;
        //拼接接口
        geturl = bundle.getString("getCookies.url");
        testurl= url + geturl;
        //发起get请求
        HttpGet httpGet= new HttpGet(testurl);
        //开始请求
        DefaultHttpClient client = new DefaultHttpClient();
        //获得请求体
        HttpResponse reponse = client.execute(httpGet);
        result = EntityUtils.toString(reponse.getEntity(),"utf-8" );
        System.out.println(result);
        //通过cookiesStore来获取请求体中的cookies
         this.cookieStore= client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        //遍历cooklist的数据并并把它存在map中
        for (Cookie cookie : cookieList){
            String name= cookie.getName();
            String value= cookie.getValue();
            System.out.println("这是key:"+name+"；  这是value："+value);
//            System.out.println("这请求返回存储的cookiesstorme："+cookieStore);
        }

    }

    //编写get氢气需要获取到cookie才能进行请求的
    @Test(dependsOnMethods="getCkooies")
    public void  getneedCk() throws IOException {
        String url1;
        String result;
        url1= bundle.getString("getneedCk");
        String testurl= url+url1;
        HttpGet httpGet = new HttpGet(testurl);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.setCookieStore(this.cookieStore);

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int statueCode = httpResponse.getStatusLine().getStatusCode();
        if ( statueCode ==200 ){
            result= EntityUtils.toString(httpResponse.getEntity());
            System.out.println("这是请求体："+result);
        }else {
            System.out.println("请求失败");
        }



    }

}
