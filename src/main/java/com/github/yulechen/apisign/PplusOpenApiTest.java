package com.github.yulechen.apisign;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.DefaultApacheHttpClient4Config;

import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PplusOpenApiTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //ehrd6843348e94b11e8b7930242ac110023
        //6ed2d58d4134884b36a97844deee42849ce4f8ab5bf2f05bc9a3a51ac52a91ce
        //"https://uat.ersoft.cn/v1/api/payslip_info"
        String accessKey = "ehrb6a1be16e94511e8b5510242ac110069";
        String accessSerrect = "2bf0fa7f34e6c99687b12454c0ca82cb0fcdb3e28e768cd7925527b2c9824cd8";
        String url = "https://symphonyodoouat.peoplus.cn/v1/api/payslip_info";
//        String bodyJson="{\"period_name\": \"201803\", \"batch_number\": \"2\"}";
//        String body ="{\"json\": "+bodyJson+"}";

        String keyBody="{\"period_name\": \"201803\", \"batch_number\": \"1\"}";
        String requsetBody ="{\"json\": \"{\\\"period_name\\\": \\\"201803\\\", \\\"batch_number\\\": \\\"1\\\"}\"}";

      //  System.out.println(body);
        Sign sign =new Sign();
        sign.setAccessKey(accessKey);
        sign.setSecretKey(accessSerrect);
        sign.setBody(keyBody);
        sign.setSignatureNonce(UUID.randomUUID().toString().replace("-", ""));
        sign.setTimestamp(getTimestamp());
        sign.setSignatureVersion("v1");
        String signature = ApiSign.getSignature(sign);
        sign.setSignature(signature);

        System.out.println();

        Client client = getClient();
        WebResource resource = client.resource(url);
        WebResource.Builder requestBuilder = resource.getRequestBuilder();
        WebResource.Builder header = requestBuilder.header("SignatureNonce" , sign.getSignatureNonce());
        requestBuilder.header("SignatureVersion" , sign.getSignatureVersion());
        requestBuilder.header("AccessKey" , sign.getAccessKey());
        requestBuilder.header("Timestamp" , sign.getTimestamp());
        requestBuilder.header("Signature" , sign.getSignature());
        ClientResponse postRestult = header.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requsetBody);

        String entity = postRestult.getEntity(String.class);
        System.out.println(entity);
    }

    private static Client getClient() {
        DefaultApacheHttpClient4Config config = new DefaultApacheHttpClient4Config();
        Client c = ApacheHttpClient4.create( config );
        return c;
    }

    private static String getTimestamp(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'CST'");
        return df.format(new Date());
    }
}
