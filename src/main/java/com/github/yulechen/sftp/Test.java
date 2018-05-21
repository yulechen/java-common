package com.github.yulechen.sftp;

public class Test {

    public static void main(String[] args) {
        System.out.println(reverseNegativeNumber("122.12-"));
        System.out.println(reverseNegativeNumber("122.12"));
    }

    public static  String reverseNegativeNumber(String num){
        if(num.endsWith("-")){
            return "-"+num.replace("-","");
        }
        return num;
    }
}
