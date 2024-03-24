package com.Flux.Runner;

import java.util.concurrent.CountDownLatch;

public class FluxRunner {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Current Thread = "+Thread.currentThread().getName()+" welcome to flux");

        // Mono Examples
        FluxResource.getMonoString()
                .map((s)->
                {
                    System.out.println(" In Flux Map Current Thread = "+Thread.currentThread().getName());
                    return s.toLowerCase();
                })
                .subscribe((s)-> {
                    System.out.println("In Subscribe Current Thread = "+Thread.currentThread().getName());
                });

        // Flux Examples
        FluxResource.getFluxOfString()
                .map((s)->
                {
                    System.out.println(" In Flux Map Current Thread = "+Thread.currentThread().getName());
                    return s.toLowerCase();
                })
                .subscribe((s)-> {
                    System.out.println("In Subscribe Current Thread = "+Thread.currentThread().getName());
                });

        System.out.println("Current Thread = "+Thread.currentThread().getName()+" going to wait");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
