package ma.formations.spring.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class SampleController {

    @GetMapping("/test1")
    Mono<String> test1() {
        return Mono.just("Hello world");
    }

    @GetMapping("/test2")
    Flux<Integer> test2() {
        return Flux.just(1, 22, 44, 55);
    }

    @GetMapping(value = "/test3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Integer> test3() {
        return Flux.just(1, 2, 3, 4, 5, 6, 7).delayElements(Duration.ofSeconds(1l)).
                log();
    }

    @GetMapping("/test")
    public String test() {
        return Thread.currentThread().getName();
    }

}
