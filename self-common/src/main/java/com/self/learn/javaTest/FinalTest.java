package com.self.learn.javaTest;

import com.self.learn.javaTest.bean.TestBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalTest {

    private void finalMethod(final TestBean age, List<TestBean> testBeans) {
        String age2 = age.getId();
        System.out.println("age2 id: " + age2 + "   age: " + age.getId());
        for (TestBean testBean : testBeans) {
            TestBean bean = testBean;
            age.setId("changeAge" + testBean.getName());
//            age2 = "2222a";
            System.out.println("age2 id: " + age2 + "   age: " + age.getId());
//        changeBean.setId("2");
//        changeBean.setName("changeName");
//        testBean = changeBean;
//            System.out.println("age2 id: " + age2);
//            System.out.println("changeBean testBean: " + bean.toString());
//        System.out.println("original2 testBean: " + testBean.toString());
            age.setId(age2);
        }
    }

    public static void main(String[] args) {
        TestBean testBeana = new TestBean();
        testBeana.setId("aabb");

        List<TestBean> testBeans = new ArrayList<>();
        TestBean testBean = new TestBean();
        testBean.setId("1");
        testBean.setName("aaron");
        TestBean testBean2 = new TestBean();
        testBean2.setId("2");
        testBean2.setName("aaron2");
        testBeans.add(testBean);
        testBeans.add(testBean2);
        new FinalTest().finalMethod(testBeana, testBeans);


        Map<String, String> tagsContext = new HashMap<>();
        tagsContext.put("a" , "aa");
        tagsContext.put("a" , "bb");
        System.out.println(tagsContext.get("a"));
    }

}
