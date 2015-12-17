package com.self.learn.UtilsTest;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronl on 10/13/2015.
 */
public class URLEncodeUtilsTest {
    private static final Logger LOG = LoggerFactory.getLogger(URLEncodeUtilsTest.class);

    @Test
    public void testFormatForVersion4() {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("a", "1"));
        params.add(new BasicNameValuePair("b", "2"));
        params.add(new BasicNameValuePair("c", null));
        params.add(new BasicNameValuePair("d", "2"));

        LOG.info(URLEncodedUtils.format(params, "UTF-8"));//a=1&b=2&c=&d=2
    }

    @Test
    public void test() {
        String regex = "^[a-zA-Z]\\w{5,17}@126\\.com";    //定义匹配的规则:正则表达式
        //说明：126.com中的.需要转义\\.
        String text = "ZhanSan@126.com";    //要检查的字符串
        boolean isMatched = text.matches(regex);    //判断text是否符合规则regex
        System.out.println(isMatched);
    }
}
