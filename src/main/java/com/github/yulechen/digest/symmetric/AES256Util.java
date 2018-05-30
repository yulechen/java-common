package com.github.yulechen.digest.symmetric;


import com.github.yulechen.digest.HexUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Map;

/**
 * java实现AES256加密解密
 * 依赖说明：
 * bcprov-jdk15-133.jar：PKCS7Padding
 * javabase64-1.3.1.jar：base64
 * local_policy.jar 和 US_export_policy.jar需添加到%JAVE_HOME%\jre\lib\security中（lib中版本适合jdk1.7）
 */

public class AES256Util {

    public static final byte[] keys="w@#$4@#$s^&3*&^4w@#$4@#$s^&3*&^4".getBytes();

    static{
        /**
         * 解决密码限制3种方式
         * https://xiaoyao9184.wordpress.com/2015/12/15/java-special-jce-3-solution-4-aes-256bits-keysize/
         */
        /**
         * 替换%JAVE_HOME%\jre\lib\security：
         *
         * jdk6
         * http://www.oracle.com/technetwork/java/embedded/embedded-se/downloads/jce-6-download-429243.html
         * jdk7
         * http://www.oracle.com/technetwork/java/embedded/embedded-se/downloads/jce-7-download-432124.html
         * jdk8
         * http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
         *
        //*It's a reflection based solution, tested on java 8*/
        fixKeyLength();
    }

    public static byte[] encrypt(String content, String password) {
        try {
            //"AES"：请求的密钥算法的标准名称
//            KeyGenerator kgen = KeyGenerator.getInstance("AES");
//            //256：密钥生成参数；securerandom：密钥生成器的随机源
//            SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
//            kgen.init(256, securerandom);
//            //生成秘密（对称）密钥
//            SecretKey secretKey = kgen.generateKey();
//            //返回基本编码格式的密钥
//            byte[] enCodeFormat = secretKey.getEncoded();
            //根据给定的字节数组构造一个密钥。enCodeFormat：密钥内容；"AES"：与给定的密钥内容相关联的密钥算法的名称
            SecretKeySpec key = new SecretKeySpec(keys, "AES");
            //将提供程序添加到下一个可用位置
            Security.addProvider(new BouncyCastleProvider());
            //创建一个实现指定转换的 Cipher对象，该转换由指定的提供程序提供。
            //"AES/ECB/PKCS7Padding"：转换的名称；"BC"：提供程序的名称
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            byte[] cryptograph = cipher.doFinal(byteContent);
            return Base64.encode(cryptograph);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(byte[] cryptograph, String password) {
        try {
//            KeyGenerator kgen = KeyGenerator.getInstance("AES");
//            SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
//            kgen.init(256, securerandom);
//            SecretKey secretKey = kgen.generateKey();
//            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(keys, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] content = cipher.doFinal(Base64.decode(cryptograph));
            return new String(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    private static byte[] tohash256Deal(String datastr) {
        try {
            MessageDigest digester=MessageDigest.getInstance("SHA-256");
            digester.update(datastr.getBytes());
            byte[] hex=digester.digest();
            return hex;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String content = "0f607264fc6318a92b9e13c65db7cd3c";
        String password = "zsyy";
        System.out.println("明文：" + content);
        System.out.println("key：" + password);

        byte[] encryptResult = AES256Util.encrypt(content, password);
        System.out.println("密文：" + HexUtil.toHexString(encryptResult));

        String decryptResult = AES256Util.decrypt(encryptResult, password);
        System.out.println("解密：" + decryptResult);
    }


    public static void fixKeyLength() {
        String errorString = "Failed manually overriding key-length permissions.";
        int newMaxKeyLength;
        try {
            if ((newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES")) < 256) {
                Class c = Class.forName("javax.crypto.CryptoAllPermissionCollection");
                Constructor con = c.getDeclaredConstructor();
                con.setAccessible(true);
                Object allPermissionCollection = con.newInstance();
                Field f = c.getDeclaredField("all_allowed");
                f.setAccessible(true);
                f.setBoolean(allPermissionCollection, true);

                c = Class.forName("javax.crypto.CryptoPermissions");
                con = c.getDeclaredConstructor();
                con.setAccessible(true);
                Object allPermissions = con.newInstance();
                f = c.getDeclaredField("perms");
                f.setAccessible(true);
                ((Map) f.get(allPermissions)).put("*", allPermissionCollection);

                c = Class.forName("javax.crypto.JceSecurityManager");
                f = c.getDeclaredField("defaultPolicy");
                f.setAccessible(true);
                Field mf = Field.class.getDeclaredField("modifiers");
                mf.setAccessible(true);
                mf.setInt(f, f.getModifiers() & ~Modifier.FINAL);
                f.set(null, allPermissions);

                newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES");
            }
        } catch (Exception e) {
            throw new RuntimeException(errorString, e);
        }
        if (newMaxKeyLength < 256)
            throw new RuntimeException(errorString); // hack failed
    }
}