package com.github.yulechen.http;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 单向认证
 */
public class JavaHttpAndHttps {

    public static void main(String[] args) {
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

       // System.out.println("http->httpRequest:"+httpRequest("http://localhost/test", "POST", postContent));
        //error
      //  System.out.println("https->httpRequest:"+httpRequest("https://localhost/test", "POST", postContent));
      // System.out.println("https->httpRequest:"+httpsRequest(new MyX509TrustAllManager(),"https://localhost/test", "POST", postContent));
        //URL resource = JavaHttpAndHttps.class.getResource("my.keystore");
        // String fileName="/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore";
        //System.out.println("https->httpRequest:"+httpsRequest(new MyX509TrustManager(fileName,"123456"),"https://192.168.1.117/test", "POST", postContent));
        //System.out.println("https->httpRequest1:"+httpsRequest1("https://192.168.1.117/test", "POST", postContent));
       System.out.println("https->httpsTwoRequest:"+httpsTwoRequest("https://p0549-iflmap.hcisbp.us2.hana.ondemand.com/http/httpTest", "GET", "{}"));

    }

    /**
     *
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static String httpRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(requestMethod);
            // add header
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            conn.connect();
            //往服务器端写内容 也就是发起http请求需要带的参数
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    // 当方法为空是默认为所有的链接都为安全,当然这样有一定的安全风险
    static class MyX509TrustAllManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }

    }


    // 使用默认为所有的链接都为安全 忽略证书信任 方式一
    public static String httpsRequest(X509TrustManager trustManager, String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            //创建SSLContext
            SSLContext sslContext= SSLContext.getInstance("SSL");
            TrustManager[] tm={trustManager};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());;
         //   sslContext.init(null, tm, null);;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            // 修改ip 不宜用，
            conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    // 方式二 将证书导入到默认受信任的文件中,更改默认的文件
    // 使用keytool -import -alias localhost -keystore my.keystore -storepass 123456 -file /Users/chenq/apps/docker_nginx_conf/certs/localhost.crt
    // 导入到 trustKeyStore 文件中
    static class MyX509TrustManager implements X509TrustManager {
        /*
         * The default X509TrustManager returned by SunX509.  We'll delegate
         * decisions to it, and fall back to the logic in this class if the
         * default X509TrustManager doesn't trust it.
         */
        X509TrustManager sunJSSEX509TrustManager;
        MyX509TrustManager(String trustStoreFile,String passphrase)  {
            try {


                // create a "default" JSSE X509TrustManager.
                KeyStore ks = KeyStore.getInstance("JKS");
                ks.load(new FileInputStream(trustStoreFile), passphrase.toCharArray());
               TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
             //   TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
                tmf.init(ks);
                TrustManager tms [] = tmf.getTrustManagers();
                /*
                 * Iterate over the returned trustmanagers, look
                 * for an instance of X509TrustManager.  If found,
                 * use that as our "default" trust manager.
                 */
                for (int i = 0; i < tms.length; i++) {
                    if (tms[i] instanceof X509TrustManager) {
                        sunJSSEX509TrustManager = (X509TrustManager) tms[i];
                        return;
                    }
                }
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (CertificateException e) {
                e.printStackTrace();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }

        }
        /*
         * Delegate to the default trust manager.
         */
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            try {
                sunJSSEX509TrustManager.checkClientTrusted(chain, authType);
            } catch (CertificateException excep) {
                // do any special handling here, or rethrow exception.
                throw  excep;
            }
        }
        /*
         * Delegate to the default trust manager.
         */
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            try {
                sunJSSEX509TrustManager.checkServerTrusted(chain, authType);
            } catch (CertificateException excep) {
                /*
                 * Possibly pop up a dialog box asking whether to trust the
                 * cert chain.
                 */
                throw  excep;
            }
        }
        /*
         * Merely pass this through.
         */
        public X509Certificate[] getAcceptedIssuers() {
            return sunJSSEX509TrustManager.getAcceptedIssuers();
        }
    }
    // 使用默认为所有的链接都为安全 忽略证书信任 方式一
    public static String httpsRequest1( String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            //创建SSLContext
            SSLContext sslContext= SSLContext.getInstance("SSL");
            KeyStore ks = KeyStore.getInstance("JKS");
            String trustStoreFile="/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore";
            ks.load(new FileInputStream(trustStoreFile), "123456".toCharArray());
          //  TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
               TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
            tmf.init(ks);
            TrustManager tms[] = tmf.getTrustManagers();


            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            KeyStore pks = KeyStore.getInstance("PKCS12");
            pks.load(new FileInputStream("/Users/chenq/apps/docker_nginx_conf/certs/client.p12"), "123456".toCharArray());
            kmf.init(pks,"123456".toCharArray());


            //初始化
            sslContext.init(kmf.getKeyManagers(), tms, null);;
            //   sslContext.init(null, tm, null);;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            // 修改ip 不宜用，
            conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }


    // 使用默认为所有的链接都为安全 忽略证书信任 方式一
    public static String httpsTwoRequest( String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
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

            //创建SSLContext
            SSLContext sslContext= SSLContext.getInstance("SSL");
//            KeyStore ks = KeyStore.getInstance("JKS");
//            String trustStoreFile="/Users/chenq/apps/docker_nginx_conf/certs/truststore/my.keystore";
//            ks.load(new FileInputStream(trustStoreFile), "123456".toCharArray());
//            //  TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
//            TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
//            tmf.init(ks);
//           TrustManager tms[] = tmf.getTrustManagers();


            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            KeyStore pks = KeyStore.getInstance("JKS");
            pks.load(new FileInputStream("/Users/chenq/code/java/java-common/src/main/java/com/github/yulechen/http/authentication/twoway/kserver.keystore"), "123456".toCharArray());
            kmf.init(pks,"123456".toCharArray());

            //初始化
            sslContext.init(kmf.getKeyManagers(), trustAllCerts, null);;

            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Authorization","Basic UzAwMTU3NDI0NDM6TWF2ZTEyMzQq");
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            // 修改ip 不宜用，
            conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }



}
