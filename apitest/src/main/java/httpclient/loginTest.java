package httpclient;

import jdk.nashorn.internal.parser.Token;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class loginTest {

    private String url;
    private ResourceBundle resourceBundle;
    private CookieStore cookieStore;
    private String  token="876F7A81E267480BB04BB7D8A4F365B306F269679164D25FA7C8E8153B7FD20E918CC795F31B0B63";


    @Test
    public void loginTest() throws IOException {

        resourceBundle=ResourceBundle.getBundle("application");
        url=resourceBundle.getString("loginTest");
        HttpPost httpPost= new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();
        JSONObject param = new JSONObject();
        param.put("usrname","Zhanger");
        param.put("password","123456");
        //设置请求头信息
        httpPost.setHeader("content-type","text/plain;charset=UTF-8");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);
        String result;
//        client.set
//        client.setUserTokenHandler(token);
        HttpResponse response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
//        this.cookieStore= client.getCookieStore();
//        List<Cookie> cookieList = cookieStore.getCookies();
//        //遍历cooklist的数据并并把它存在map中
//        for (Cookie cookie : cookieList) {
//            String name = cookie.getName();
//            String value = cookie.getValue();
//            System.out.println("这是key:" + name + "；  这是value：" + value);
//        }

//       //将返回的相应结果字符串转化成json对象
//        JSONObject resultJson = new JSONObject(result);
//        //具体的判断返回结果值
//        String info =(String) resultJson.get("info");
//
//        System.out.println("这是获取的token值："+token);


    }

    //上传历史的接口测试
    @Test
    public  void shangchuanTest() throws IOException {
        String url="http://218.207.155.110:8082/sjwl_app/ElectronicControl/saveSaleRecord";
        HttpPost httpPost= new HttpPost(url);
        DefaultHttpClient defaultHttpClient= new DefaultHttpClient();
        JSONObject param=new JSONObject();
        param.put("token",token);
//        param.put("content-type","application/x-www-form-urlencoded");
        param.put("data","[{\"foreignKey\":1,\"id\":1,\"result\":\"111\",\"status\":\"0\",\"uuid\":\"bf005aa6-57cc-4c5e-9319-3ad00cfd39b8\",\"z_back\":\"0\",\"z_electronic_no\":\"000116\",\"z_giftcard_no\":\"\",\"z_goods_id\":\"300001\",\"z_goods_nm\":\"压力测试\",\"z_goods_no\":\"002\",\"z_goods_order\":\"1\",\"z_money\":\"2.9\",\"z_no\":\"1\",\"z_num\":\"0.144\",\"z_onsale_num\":\"0\",\"z_onsale_type\":\"-1\",\"z_org_id\":\"25452488\",\"z_pay_type\":\"cash\",\"z_pcno\":\"PC-20181130\",\"z_pd\":\"0\",\"z_price\":\"20.0\",\"z_remark\":\"\",\"z_sale_dt\":\"2019-05-10\",\"z_sale_no\":\"000001\",\"z_sale_tm\":\"2019-05-18 18:46:07\",\"z_staff_id\":\"30197450\",\"z_staff_nm\":\"压力测试\",\"z_store_id\":\"28388389\",\"z_store_nm\":\"集美门\",\"z_unit\":\"3\",\"z_unit_nm\":\"KG\",\"z_weight\":\"0.144\"}]");
        httpPost.setHeader("content-type","application/x-www-form-urlencoded");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);
        HttpResponse httpResponse = defaultHttpClient.execute(httpPost);

        //获取相应结果
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("这是上传历史的返回参数："+result);


    }

}
