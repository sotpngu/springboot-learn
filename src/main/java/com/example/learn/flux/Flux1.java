package com.example.learn.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class Flux1 {

    public static void main(String[] args) {
        Flux.just("gaominghao", "zhangchunbo", "xuzhixu")
                .map(String::toUpperCase)
                .flatMap(s -> Flux.fromArray(s.split("")))
                .groupBy(String::toString)
                .sort((o1, o2) -> o1.key().compareTo(o2.key()))
                .subscribe(System.out::println);

                // .subscribe(f -> f.subscribe(t -> System.out.println(f.key() + ":" + t)));

                // .subscribe(System.out::println);
    }

}
