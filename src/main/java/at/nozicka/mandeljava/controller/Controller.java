package at.nozicka.mandeljava.controller;

import at.nozicka.mandeljava.logic.Mandel;
import at.nozicka.mandeljava.logic.MandelMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @GetMapping("/actuator/health")
    public Mono<String> health() {

        var result = "healthy";

        return Mono.just(result);
    }

    @GetMapping("/mandel_java/mandel_text/{maxIter}/{height}/{width}")
    public Mono<String> mandel(@PathVariable int maxIter, @PathVariable int height, @PathVariable int width) {

        var result = Mandel.mandel(maxIter, height, width);

        return Mono.just(result);
    }

    @GetMapping("/mandel_java/mandel_text_memory/{maxIter}/{height}/{width}")
    public Mono<String> mandelMemory(@PathVariable int maxIter, @PathVariable int height, @PathVariable int width) {

        var result = MandelMemory.mandel(maxIter, height, width);

        return Mono.just(result);
    }
}