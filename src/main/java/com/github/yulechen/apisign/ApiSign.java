package com.github.yulechen.apisign;

import org.apache.commons.codec.DecoderException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ApiSign {

    public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {
        String signatureNonce = UUID.randomUUID().toString().replace("-","");
         String SignatureNonce ="33da178cd05011e8a7f04a00082e9cb0";
         System.out.println(SignatureNonce.length()== UUID.randomUUID().toString().replace("-","").length());
         String SignatureVersion="V1";
         String SignatureOld="d29662aafc5d638645b5f4e0e3748fb47957ae9856f4821ebb7cbb62b24aea2d";
         String Signature="";
         String AccessKey="ehr8290ce54b6f911e887c66c96cfd9fb21";
         String Timestamp="2018-10-15T07:59:12CST";
         String body ="a";

        String  signStr=String.format("body=%s&timestamp=%s&signatureNonce=%s",body,Timestamp,SignatureNonce);
        String key ="346a0b1629f21b29a8d4f8c6819774e79bc81bb2e84365ac3249efe8eaaec16c";
        Signature=HMACSHA256(signStr.getBytes("utf-8"),key.getBytes("utf-8"));
        System.out.println(Signature);
        System.out.println(SignatureOld);
        System.out.println(SignatureOld.equals(Signature));
  //      System.out.println(getTimestamp());
    }
    public static String HMACSHA256(byte[] data, byte[] key)
    {
        try  {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

     public static String getTimestamp(){
         DateFormat df = new SimpleDateFormat("yyyy'T'MM月dd日 HH时mm分ss秒");
         return df.format(new Date());
    }
}
