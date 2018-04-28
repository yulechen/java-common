#!/usr/bin/env bash
#
#java 双向认证证书生成
#
#keytool -genkey -keyalg RSA -alias client -keystore keystore.jks -storepass 123456 -validity 360 -keysize 2048
#keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.jks -deststoretype pkcs12

#提取证书
openssl pkcs12 -in keystore.jks -nokeys -clcerts -out server-ssl.crt
openssl pkcs12 -in keystore.jks -nokeys -cacerts -out gs_intermediate_ca.crt

#合并证书
cat server-ssl.crt gs_intermediate_ca.crt >client.crt

#提取私钥
openssl pkcs12 -nocerts -nodes -in newkeystore.p12 -out server.key