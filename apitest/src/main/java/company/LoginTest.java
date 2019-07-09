package company;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginTest {

    private String url;
    private String result;
    @Test
    public void getToken() throws IOException {

        //配置接口的url地址，可以用配置文件拼接的形式
        url="http://218.207.155.110:8082/sjwl_app/login";
        HttpPost httpPost= new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("usrname","zhangjinhui"));
        qparams.add(new BasicNameValuePair("password", "1"));
        HttpEntity paramEntity= new UrlEncodedFormEntity(qparams,"utf-8");
        httpPost.setEntity(paramEntity);
        HttpResponse httpResponse= client.execute(httpPost);
        result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);
//        System.out.println(httpResponse);
        String str = result;
        org.json.JSONObject resultJson = new org.json.JSONObject(result);


        //获取到结果值
        String success = (String) resultJson.get("flag");
        System.out.println("token是："+success);

    }

    //上传历史订单记录
    @Test
    public void historyOrder() throws IOException {
        url="http://218.207.155.110:8082/sjwl_app/ElectronicControl/saveSaleRecord";
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost= new HttpPost(url);
        List<NameValuePair> params= new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("token","3CA75F20E6AFF92FB756585F7629EB8BAAC70AA3FB19C47F0923F4265FC23445189BC3611604B636"));
        params.add(new BasicNameValuePair("content-type","application/x-www-form-urlencoded"));
        params.add(new BasicNameValuePair("z_data","[{\"foreignKey\":1,\"id\":1,\"result\":\"111\",\"status\":\"0\",\"uuid\":\"bf005aa6-57cc-4c5e-9319-3ad00cfd39b8\",\"z_back\":\"0\",\"z_electronic_no\":\"000116\",\"z_giftcard_no\":\"\",\"z_goods_id\":\"300001\",\"z_goods_nm\":\"压力测试\",\"z_goods_no\":\"002\",\"z_goods_order\":\"1\",\"z_money\":\"2.9\",\"z_no\":\"1\",\"z_num\":\"0.144\",\"z_onsale_num\":\"0\",\"z_onsale_type\":\"-1\",\"z_org_id\":\"25452488\",\"z_pay_type\":\"cash\",\"z_pcno\":\"PC-20181130\",\"z_pd\":\"0\",\"z_price\":\"20.0\",\"z_remark\":\"\",\"z_sale_dt\":\"2019-05-10\",\"z_sale_no\":\"000001\",\"z_sale_tm\":\"2019-05-18 18:46:07\",\"z_staff_id\":\"30197450\",\"z_staff_nm\":\"压力测试\",\"z_store_id\":\"28388389\",\"z_store_nm\":\"集美门\",\"z_unit\":\"3\",\"z_unit_nm\":\"KG\",\"z_weight\":\"0.144\"}]"));
        HttpEntity paramEntity= new UrlEncodedFormEntity(params,"utf-8");
        httpPost.setEntity(paramEntity);
        httpPost.setHeader("token","3CA75F20E6AFF92FB756585F7629EB8BAAC70AA3FB19C47F0923F4265FC23445189BC3611604B636");
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");

//        List<NameValuePair> header= new ArrayList<NameValuePair>();
//        header.add(new BasicNameValuePair("token","3CA75F20E6AFF92FB756585F7629EB8BAAC70AA3FB19C47F0923F4265FC23445189BC3611604B636"));
//        HttpHeaders headers= new HttpHeaders();
        HttpResponse httpResponse= httpClient.execute(httpPost);
        result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);
        org.json.JSONObject resultJson = new org.json.JSONObject(result);


        //获取到结果值
        String success = (String) resultJson.get("flag");
        System.out.println("这是返回结果状态："+success);
//        String status = (String) resultJson.get("status");
        //具体的判断返回结果的值
            Assert.assertEquals("true",success);
//        Assert.assertEquals("1",status);

    }

//    @Test
//    public void postForm() {
//        // 创建默认的httpClient实例.
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        // 创建httppost
//        HttpPost httppost = new HttpPost("http://218.207.155.110:8082/sjwl_app/login");
//        // 创建参数队列
//        List formparams = new ArrayList();
//        formparams.add(new BasicNameValuePair("usrname", "zhangjinhui"));
//        formparams.add(new BasicNameValuePair("password", "1"));
//        UrlEncodedFormEntity uefEntity;
//        try {
//            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//            httppost.setEntity(uefEntity);
//            System.out.println("executing request " + httppost.getURI());
//            CloseableHttpResponse response = httpclient.execute(httppost);
//            try {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    System.out.println("--------------------------------------");
//                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
//                    System.out.println("--------------------------------------");
//                }
//            } finally {
//                response.close();
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭连接,释放资源
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
