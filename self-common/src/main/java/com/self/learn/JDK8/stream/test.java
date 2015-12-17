package com.self.learn.JDK8.stream;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
    private static final Set<String> ANONYMOUS_EMAIL = new HashSet<>();

    static {
        ANONYMOUS_EMAIL.add("@ehealth.com");
        ANONYMOUS_EMAIL.add("@ehealthinsurance.com");
        ANONYMOUS_EMAIL.add("anonymous");
    }

    private static boolean isIllegalNewEmail(String oriEmail, String newEmail) {
        if (StringUtils.isBlank(newEmail)) {
            return true;
        }
        if (isAnonymousEmail(newEmail)) {
            return true;
        }
        return oriEmail.equalsIgnoreCase(newEmail);
    }

    private static boolean isAnonymousEmail(String email) {
        return ANONYMOUS_EMAIL.contains(email.toLowerCase());
//        for (String anonymousEmail : ANONYMOUS_EMAIL) {
//            if (email.toLowerCase().indexOf(anonymousEmail) > -1) {
//                return true;
//            }
//        }
//        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list = null;
//        list.addAll(new ArrayList<>());

        String newEmail = "@ehealth.com";
        String oriEmail = "aa@Aanaonymoustah.com";
        System.out.print(isAnonymousEmail(newEmail));

//        BufferedReader bufferedReader = new BufferedReader();
//        bufferedReader.lines()
    }
}
