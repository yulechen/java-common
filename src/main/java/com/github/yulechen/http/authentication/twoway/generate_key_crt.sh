#!/usr/bin/env bash
#密匙库格式 ： JKS  java 专用，PKCS12行业标准格式
#
# keytool
#server.keystore是给服务端用的，其中保存着自己的私钥，私钥里面包含有公钥信息
#keytool -genkey -alias serverkey -keystore kserver.keystore

#建议使用 "keytool -importkeystore -srckeystore kserver.keystore -destkeystore kserver.keystore -deststoretype pkcs12"

#根据私钥，导出服务端证书
keytool -export -alias serverkey -keystore kserver.keystore -file server.crt

# 将服务端证书，导入到客户端的Trust KeyStore中