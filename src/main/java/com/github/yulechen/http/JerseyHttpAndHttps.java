package com.github.yulechen.http;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.DefaultApacheHttpClient4Config;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import org.glassfish.grizzly.ssl.SSLContextConfigurator;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.security.KeyStore;

public class JerseyHttpAndHttps {
    public static void main(String[] args) throws Exception {
       // System.setProperty("javax.net.ssl.trustStore", "/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore");
       // System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        DefaultApacheHttpClient4Config config = setConfig();
        Client client = ApacheHttpClient4.create( config );
        WebResource webResource = client.resource("https://localhost/test");
        String postContent="{\n" +
                "    \"header\": {\n" +
                "        \"serviceCode\": \"TEST\",\n" +
                "        \"serviceName\": \"design\",\n" +
                "        \"method\": \"test\",\n" +
                "        \"IP\": \"192.168.1.117\"\n" +
                "    },\n" +
                "    \"body\": {\n" +
                "        \"url\": \"https://apisalesdemo8.successfactors.com:443/sfapi/v1/soap\",\n" +
                "        \"userName\": \"sfadmin\",\n" +
                "        \"password\": \"runbest\",\n" +
                "        \"companyId\": \"SFPART007340\"\n" +
                "    },\n" +
                "    \"pageBean\": {}\n" +
                "}";
        WebResource.Builder builder = webResource.getRequestBuilder();
        ClientResponse post = builder.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, postContent);
        System.out.println(post.getStatus());

    }


    public static DefaultApacheHttpClient4Config setConfig() throws Exception {
        DefaultApacheHttpClient4Config config = new DefaultApacheHttpClient4Config();
        KeyStore trustStore = KeyStore.getInstance( "JKS" );
        trustStore.load( new FileInputStream("/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore" ), "123456".toCharArray() );
        TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
        tmf.init( trustStore );
        SSLContext ctx = SSLContext.getInstance( "SSL" );
        ctx.init( null, tmf.getTrustManagers(), null );
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify( String hostname, SSLSession session ) {
                return true;
            }
        };
        config.getProperties().put( HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties( hv, ctx ) );
        return config;
    }
}
