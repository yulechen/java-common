package com.github.yulechen.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {


    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        UniqueEmails uniqueEmails = new UniqueEmails();
        long start = System.currentTimeMillis();
        System.out.println(uniqueEmails.numUniqueEmails1(emails));
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for (String email : emails) {
            int atIndex = email.indexOf("@");
            String localName = email.substring(0, atIndex);
            String domainName = email.substring(atIndex);
            StringBuffer myLoaclName = new StringBuffer();
            for (int i = 0; i < localName.length(); i++) {
                char c = localName.charAt(i);
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    myLoaclName.append(c);
                }

            }
            set.add(myLoaclName.append(domainName).toString());

        }
        return set.size();
    }


    public int numUniqueEmails1(String[] emails) {
        Set<String> set = new HashSet<String>();
        for (String email : emails) {
            int length = email.length();
            StringBuffer buffer = new StringBuffer();
            boolean isPlused = false;
            for (int i = 0; i < length; i++) {
                char c = email.charAt(i);
                if (c == '@') {
                    buffer.append(email.substring(i));
                    break;

                    // waste time here.
                } else if (isPlused || c == '+') {
                    isPlused = true;
                    continue;
                }
                if (c != '.')
                    buffer.append(c);
            }

            set.add(buffer.toString());
        }
        return set.size();
    }
}
