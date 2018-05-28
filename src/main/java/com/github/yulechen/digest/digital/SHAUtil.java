package com.github.yulechen.digest.digital;



import com.github.yulechen.digest.HexUtil;

import java.security.MessageDigest;

/**
 * SHA的全称是Secure Hash Algorithm，即安全散列算法
 * Created by fangzhipeng on 2017/3/21.
 */
public class SHAUtil {

    /**
     * 定义加密方式
     */
    private final static String KEY_SHA = "SHA";
    private final static String KEY_SHA1 = "SHA-1";


    /**
     * 构造函数
     */
    public SHAUtil() {

    }

    /**
     * SHA 加密
     * @param data 需要加密的字节数组
     * @return 加密之后的字节数组
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {
        // 创建具有指定算法名称的信息摘要
//        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data);
        // 完成摘要计算并返回
        return sha.digest();
    }

    /**
     * SHA 加密
     * @param data 需要加密的字符串
     * @return 加密之后的字符串
     * @throws Exception
     */
    public static String encryptSHA(String data) throws Exception {
        // 验证传入的字符串
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return HexUtil.toHexString(bytes);
    }

    public static String encryptSHA256(String data) throws Exception {
        // 验证传入的字符串
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return HexUtil.toHexString(bytes);
    }



    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String key = "123";
        String s = encryptSHA(key);
        System.out.println("结果位数:   " +HexUtil.bits(s));
        System.out.println("16进制字符串结果：  "+s);

        String s1 = encryptSHA256(key);
        System.out.println("结果位数:   " +HexUtil.bits(s1));
        System.out.println("16进制字符串结果：  "+s1);
    }
}
