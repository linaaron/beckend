package com.self.learn.pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaronl on 11/11/2015.
 */
public class PatternDemo {
    private static final Pattern PATTEN_1 = Pattern.compile("\\{([^\\{\\}]+)\\}");
    private static final Pattern TYPE_PATTEN = Pattern.compile("(?:^|/?|&)type=([^&]*)(?:&|$)");

    @Test
    public void patternTest() {
        String testString = "Hi men, {a}, and {{b}";
        Matcher matcher = PATTEN_1.matcher(testString);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
