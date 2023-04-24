package at.nozicka.mandeljava.controller;

import at.nozicka.mandeljava.logic.Mandel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {
    @GetMapping("/mandel_java/mandel_text/{maxIter}")
    public Mono<String> sayHello(@PathVariable int maxIter) {

        var result = Mandel.mandel(maxIter);

        return Mono.just(result);
    }
}