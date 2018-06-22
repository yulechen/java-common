package com.github.yulechen.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
//https://www.infoq.com/articles/reactor-by-example/

public class FluxMain {
    public static void main(String[] args) {

    }


    // 生产者  -- 消费者模式
    public static void  createSimpleFlux(){
        //just()：可以指定序列中包含的全部元素。创建出来的 Flux 序列在发布这些元素之后会自动结束
        Flux.just("Hello", "World").subscribe(System.out::println);

        //可以从一个数组、Iterable 对象或 Stream 对象中创建 Flux 对象。
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);

        //创建一个不包含任何元素，只发布结束消息的序列
        Flux.empty().subscribe(System.out::println);

        //创建包含从 start 起始的 count 个数量的 Integer 对象的序列
        Flux.range(1, 10).subscribe(System.out::println);

        //创建一个包含了从 0 开始递增的 Long 对象的序列。其中包含的元素按照指定的间隔来发布。
        // 除了间隔时间之外，还可以指定起始元素发布之前的延迟时间
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
    }

    /**
     *
     * create()方法与 generate()方法的不同之处在于所使用的是 FluxSink 对象
     * 。FluxSink 支持同步和异步的消息产生，
     * 并且可以在一次调用中产生多个元素。在代码清单 3 中，在一次调用中就产生了全部的 10 个元素
     */
    public  static void createFulxByGenerate(){
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);


        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

        // use create
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }
}
