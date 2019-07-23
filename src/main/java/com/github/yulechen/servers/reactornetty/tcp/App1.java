package com.github.yulechen.servers.reactornetty.tcp;

import reactor.core.publisher.Flux;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

/**
 * @Author: chenq
 * @Date: 2019/7/23  下午2:03
 */
public class App1 {

  public static void main(String[] args) {
    DisposableServer server = TcpServer.create()
        .host("localhost")
        .port(8080)
        .handle((inbound, outbound) ->{
          // in
          inbound.receive().then();
          //out
          return  outbound.options(o -> o.flushOnEach(false)).sendString(Flux.just("Hello","World","/"));

          }
        )
        .bindNow();

    server.onDispose().block();
    }
  }

