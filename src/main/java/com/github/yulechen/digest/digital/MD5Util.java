package com.github.yulechen.digest.digital;

import com.github.yulechen.digest.HexUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Message Digest Algorithm 5(信息摘要算法5)
 */
public class MD5Util {
    /**
     * Constructs the MD5Util object and sets the string whose MD5Util is to be
     * computed.
     * 
     * @param inStr
     *    the <code>String</code> whose MD5Util is to be computed
     */
    
    
    public final static String COMMON_KEY="zhongzhuoxin#@!321";
    public MD5Util() {

    }

    public final static String str2MD5(String inStr) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = inStr.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            return HexUtil.toHexString(md);
        } catch (Exception e) {
            return null;
        }
    }
    


    public static String AndroidMd5(String s) {
        try {
            // Create MD5Util Hash
            MessageDigest digest = MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            return HexUtil.toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {

        String m = MD5Util.str2MD5("swwwwwwwwwwdkinnerdsfdsfdsfdsf");

        System.out.println("结果位数:   " +HexUtil.bits(m));
        System.out.println("16进制字符串结果：  "+m);

    }
}

