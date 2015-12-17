package com.self.learn.httpClientHelper;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class httpClientDemo {

//    private final static MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
//    private final static HttpClient httpClient = new HttpClient();
//    public static void main(String[] args) {
//        httpClient.set
//    }

    @Test
    public void simpleClient() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            int l;
            byte[] tmp = new byte[2048];
            while ((l = instream.read(tmp)) != -1) {
            }
        }
    }


    public void saveEmailInvokeBoseScript(String scriptSessionId, String newEmail) {
      /*  try {
            String url = "http://www9.local.com:8082/script/partner/save-email?sessionId=189512&email=aaaaaa350test@test.com";
            RestClient drxClient = new RestClient() {
            };
            URI uri = URI.create(url);
            JerseyWebTarget searchTarget = drxClient.getClient().target(uri);
            String sponse = searchTarget.request().header("Content-Type", "application/xml").get(String.class);
        } catch (Exception e) {
//            Log.logError("SaveEmailHelper.saveEmailInvokeBoseScript: " + e.getMessage());
        }*/
    }
}
