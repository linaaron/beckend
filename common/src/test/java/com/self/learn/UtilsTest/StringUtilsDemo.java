package com.self.learn.UtilsTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by aaronl on 10/11/2015.
 */
public class StringUtilsDemo {
    private static final Logger LOG = LoggerFactory.getLogger(StringUtilsDemo.class);

    public static void main(String[] args) {
        StringUtilsAbbreviate();
    }

    public void StringUtilsSplit() {
        String[] strs = "  ,1,,2,".split(","); //{"  ","1","","2"}
        String[] strs2 = StringUtils.split("  ,1,,2,", ","); //{"  ","1","2"}
    }

    public static void StringUtilsAbbreviate() {
        LocalDate.now();
        LOG.info(StringUtils.abbreviate("This is a test for abbreviate", 6));
        LOG.info(StringUtils.abbreviate("This is a test for abbreviate", 3,8));
    }

    @Test
    public void test() {
        System.out.println(UUID.randomUUID());
        System.out.println(String.valueOf(1));
    }


}
