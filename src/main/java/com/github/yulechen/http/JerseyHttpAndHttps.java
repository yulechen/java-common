package com.github.yulechen.http;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.ApacheHttpClient4Config;
import com.sun.jersey.client.apache4.config.DefaultApacheHttpClient4Config;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

import javax.net.ssl.*;
import javax.ws.rs.core.MediaType;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class JerseyHttpAndHttps {
    public static void main(String[] args) throws Exception {
        //System.setProperty("javax.net.ssl.trustStore", "/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore");
        //System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        DefaultApacheHttpClient4Config config = setConfig();
        Client client = ApacheHttpClient4.create( config );
        WebResource webResource = client.resource("https://192.168.1.117/test");
        String postContent="{\"header\": {\"serviceCode\": \"TEST\",\"serviceName\": \"design\",\"method\":\"testConntect\"},\"body\": {\"timeout\": 1}}";
        WebResource.Builder builder = webResource.getRequestBuilder();
        ClientResponse post = builder.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, postContent);
        System.out.println(post.getStatus());
        System.out.println(post.getEntity(String.class));


    }


    public static DefaultApacheHttpClient4Config setConfig() throws Exception {
        DefaultApacheHttpClient4Config config = new DefaultApacheHttpClient4Config();
//        KeyStore trustStore = KeyStore.getInstance( "JKS" );
//        trustStore.load( new FileInputStream("/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore" ), "123456".toCharArray() );
//
//        // Trust key
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
//        tmf.init( trustStore );
//
//        // private key
//        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
//        KeyStore ks = KeyStore.getInstance("JKS");
//        ks.load(new FileInputStream("/Users/chenq/code/java/java-common/src/main/java/com/github/yulechen/http/authentication/twoway/kserver.keystore"), "123456".toCharArray());
//        kmf.init(ks,"123456".toCharArray());
//        SSLContext ctx = SSLContext.getInstance( "SSL" );
//        ctx.init( kmf.getKeyManagers(), tmf.getTrustManagers(), null );
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify( String hostname, SSLSession session ) {
                return true;
            }
        };
        SSLContext insecureSSLContext = SSLUtil.getInsecureSSLContext();
        // this code not  Take effect
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties( hv,  insecureSSLContext) );

        SSLSocketFactory sf = new SSLSocketFactory(insecureSSLContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        Scheme scheme = new Scheme("https", sf, 443);
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager();
        threadSafeClientConnManager.getSchemeRegistry().register(scheme);
        config.getProperties().put(ApacheHttpClient4Config.PROPERTY_CONNECTION_MANAGER,threadSafeClientConnManager);

        return config;
    }

    private static class SSLUtil {
        protected static SSLContext getInsecureSSLContext()
                throws KeyManagementException, NoSuchAlgorithmException {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                final java.security.cert.X509Certificate[] arg0, final String arg1)
                                throws CertificateException {
                            // do nothing and blindly accept the certificate
                        }

                        public void checkServerTrusted(
                                final java.security.cert.X509Certificate[] arg0, final String arg1)
                                throws CertificateException {
                            // do nothing and blindly accept the server
                        }

                    }
            };
            final SSLContext sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, trustAllCerts,
                    new java.security.SecureRandom());
            return sslcontext;
        }
    }

}
