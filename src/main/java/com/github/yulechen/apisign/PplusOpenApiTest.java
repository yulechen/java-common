package com.github.yulechen.apisign;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.ApacheHttpClient4Config;
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

        //
        String accessKey = "ehrb6a1be16e94511e8b5510242ac110069";
        String accessSerrect = "2bf0fa7f34e6c99687b12454c0ca82cb0fcdb3e28e768cd7925527b2c9824cd8";
        String url = "https://symphonyodoouat.peoplus.cn/v1/api/payslip_info";


        String keyBody="{\"period_name\": \"201803\", \"batch_number\": \"1\"}";
        String requsetBody =keyBody; //"{\"json\": \"{\\\"period_name\\\": \\\"201803\\\", \\\"batch_number\\\": \\\"1\\\"}\"}";



        // sexam-p+
        url="http://p8akqe.natappfree.cc/training/check_auth";
        //url="http://192.168.1.117:8080/Login/admin";
        //url="http://192.168.1.200:8083/Login/admin";
        accessKey="ehr93fc5b2eb7c611e8b8190242ac11006c";
        accessSerrect ="1fdc98e766e8fd040934e56cb1fdc1c87ca75ff5854d37681aa0d4890ce9ac61";
        long current= System.currentTimeMillis();
        keyBody=String.format("{\n" +
                "    \"data\": {\n" +
                "        \"identify_id\": \"%s\",  " +
                "        \"request_id\": \"%s\",   " +
                "        \"vals\": {\n" +
                "            \"login\": \"system\",         " +
                "            \"password\": \"123456\"        " +
                "        }\n" +
                "    }\n" +
                "}",current,current);

        //keyBody="{\"data\": {\"identify_id\": \"1542854649645\",\"request_id\": \"1542854649645\",\"vals\": {\"login\": \"system\",\"password\": \"123456\"}}}";
        keyBody="{\"data\": {\"vals\": {\"login\": \"system\",\"password\": \"123456\"}}}";
        requsetBody=keyBody;

       // System.out.println(keyBody);
        Sign sign =new Sign();
        sign.setAccessKey(accessKey);
        sign.setSecretKey(accessSerrect);
        sign.setBody(keyBody);
        sign.setSignatureNonce(UUID.randomUUID().toString().replace("-", ""));
        sign.setTimestamp(getTimestamp());
        sign.setSignatureVersion("V1");
        String signature = ApiSign.getSignature(sign);
        System.out.println(signature);
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
      //  requestBuilder.header("SignatureMethod" , "HMAC-SHA256");
        System.out.println(requsetBody);
        ClientResponse postRestult = requestBuilder.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requsetBody);
        String restultEntity = postRestult.getEntity(String.class);
        System.out.println(restultEntity);
    }

    private static Client getClient() {
        // no way to close Transcode-enconding
        DefaultApacheHttpClient4Config config = new DefaultApacheHttpClient4Config();
        Client c = ApacheHttpClient4.create( config );
       // c.getProperties().put(PROPERTY_HTTP_PARAMS,)
        // disable Transfer-Encoding=chunked
        c.getProperties().put(ApacheHttpClient4Config.PROPERTY_ENABLE_BUFFERING,true);
        c.setChunkedEncodingSize(null);
        return c;
    }

    private static String getTimestamp(){
        //Z-CST
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return df.format(new Date());
    }
}
