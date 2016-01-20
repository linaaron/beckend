package com.self.groupcache;

import net.rubyeye.xmemcached.*;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class XMemcachedDemo {

    public void test() throws IOException {
//        10.172.78.112:11211;10.172.78.113:11211
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("10.172.78.112:11211"));
        builder.setFailureMode(true);
        builder.setCommandFactory(new BinaryCommandFactory()); //使用二进制文件
        builder.setConnectionPoolSize(10); //default 1
        Map<InetSocketAddress, AuthInfo> authInfoMap = new HashMap<>();
        authInfoMap.put(AddrUtil.getOneAddress("10.172.78.112:11211"), AuthInfo.plain("bo@ehealthinsurance.com", "ekG4hwp254"));
        builder.setAuthInfoMap(authInfoMap);
        MemcachedClient client = builder.build();

        try {
            client.add("hello", 0, "hello xmemcached");
            String value = client.get("hello");
            System.out.println("hello=" + value);
            client.delete("hello");
            System.out.println("hello=" + client.get("hello"));

            client.add("test", 0, 3);
            //cas操作第一种方法
            GetsResponse<Integer> result = client.gets("test");
            long cas = result.getCas();
            if (client.cas("test", 0, 2, cas)) {
                System.out.println("cas correct =============================================");
            }
            //cas操作第二种方法
            client.cas("test", 0, new CASOperation<Integer>() {
                public int getMaxTries() {
                    return 1;
                }

                public Integer getNewValue(long currentCAS, Integer currentValue) {
                    return 2;
                }
            });
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }

        client.shutdown();
    }

    //    @Test
    public void testMemcachedClientMethod() throws IOException {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("10.172.78.112:11211 10.172.78.113:11211"));
        builder.setCommandFactory(new BinaryCommandFactory());
//        builder.setSessionLocator(new KetamaMemcachedSessionLocator());
        Map<InetSocketAddress, AuthInfo> authInfoMap = new HashMap<>();
        authInfoMap.put(AddrUtil.getOneAddress("10.172.78.112:11211"), AuthInfo.plain("bo@ehealthinsurance.com", "ekG4hwp254"));
        authInfoMap.put(AddrUtil.getOneAddress("10.172.78.113:11211"), AuthInfo.plain("bo@ehealthinsurance.com", "ekG4hwp254"));
        builder.setAuthInfoMap(authInfoMap);
        MemcachedClient client = builder.build();

        try {
            client.add("name", 0, "china");
            System.out.println("-----------------------name=" + client.get("name"));
            client.flushAll();
            System.out.println("-----------------------flushAll name=" + client.get("name"));
            if (!client.set("hello", 0, "worldSet")) {
                System.out.println("------------------set error");
            }
            System.out.println("-------------------set hello=" + client.get("hello"));
            if (client.set("hello", 0, "worldSet2")) {
                System.out.println("------------------set correct");
            }
            System.out.println("-------------------set2 hello=" + client.get("hello"));
            if (!client.add("hello", 0, "worldAdd")) {
                System.out.println("------------------add error,it's existed");
            }
            System.out.println("-------------------add exist hello=" + client.get("hello"));
            if (!client.replace("hello", 0, "worldReplace")) {
                System.out.println("------------------replace error");
            }
            System.out.println("-------------------replace hello=" + client.get("hello"));
            client.append("hello", "good====");
            System.out.println("-------------------append hello=" + client.get("hello"));
            client.prepend("hello", "1hello2");
            System.out.println("-------------------prepend hello=" + client.get("hello"));
            System.out.println("-------------------prepend hello=" + client.get("hello", new StringTranscoder()));
            client.deleteWithNoReply("hello");
            System.out.println("-------------------deleteWithNoReply hello=" + client.get("hello"));
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } finally {
            client.shutdown();
        }
    }

    public static void main(String[] args) throws IOException {
        XMemcachedDemo xMemcachedDemo = new XMemcachedDemo();
        xMemcachedDemo.test();
//        xMemcachedDemo.testMemcachedClientMethod();
    }
}
