package com.Flux.Runner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class FluxResource {

    public static Mono<String> getMonoString()
    {
        return Mono.just("Mayank").delayElement(Duration.ofSeconds(1));
    }

    public static Flux<String> getFluxOfString()
    {
        return Flux.just("Mayank", "Shashank", "Ankur", "Tripathi")
                .delayElements(Duration.ofSeconds(1));
    }
}
