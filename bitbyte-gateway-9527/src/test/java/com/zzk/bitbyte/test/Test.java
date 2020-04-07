package com.zzk.bitbyte.test;

import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zzk
 * @Date: 2020-02-25 10:10
 */
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test(){
        Mono.just(TimeUnit.MINUTES.toSeconds(60)).subscribe(System.out::println);
    }
}
