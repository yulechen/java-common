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

public class ApiSign {

    public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {
        //String signatureNonce = UUID.randomUUID().toString().replace("-", "");


        String SignatureNonce = "cc406b6ee96611e8a55df0761cc0b1fa";
        String SignatureVersion = "v1";
        String AccessKey = "ehrb6a1be16e94511e8b5510242ac110069";
        String Timestamp = "2018-11-16T06:13:55CST";
        String SecretKey = "2bf0fa7f34e6c99687b12454c0ca82cb0fcdb3e28e768cd7925527b2c9824cd8";
        String body = "a";

        // 加密：
        String signStr = String.format("body=%s&timestamp=%s&signatureNonce=%s", body, Timestamp, SignatureNonce);
        String Signature = HMACSHA256(signStr.getBytes("utf-8"), SecretKey.getBytes("utf-8"));
        System.out.println("SignatureNonce:" + SignatureNonce);
        System.out.println("SignatureVersion:" + SignatureVersion);
        System.out.println("AccessKey:" + AccessKey);
        System.out.println("Timestamp:" + Timestamp);
        System.out.println("body:" + body);
        System.out.println("Signature:" + Signature);

    }



    public static String getSignature(Sign sign) throws UnsupportedEncodingException {
        String signStr = String.format("body=%s&timestamp=%s&signatureNonce=%s", sign.getBody(), sign.getTimestamp(), sign.getSignatureNonce());
      //  String signStr = String.format("body=%s&signatureNonce=%s", sign.getBody(), sign.getSignatureNonce());
        return HMACSHA256(signStr.getBytes("utf-8"), sign.getSecretKey().getBytes("utf-8"));
    }



    public static String HMACSHA256(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data));
          //  return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }



    public static String getTimestamp() {
        DateFormat df = new SimpleDateFormat("yyyy'T'MM月dd日 HH时mm分ss秒");
        return df.format(new Date());
    }
}
