package com.monir.redisspring.fib.controller;

import com.monir.redisspring.fib.services.FibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("fib")
public class FiboController {

    @Autowired
    private FibService fibService;

    @GetMapping("{index}")
    public Mono<Integer> getFibo(@PathVariable int index){
        return Mono.fromSupplier(()-> this.fibService.getFib(index));
    }

    //cacheEvict is only applicable for PUT/POST/DELETE etc. But not GET method
    @GetMapping("{index}/clear")
    public Mono<Void> clearCache(@PathVariable int index){
        return Mono.fromRunnable(()->this.fibService.clearCache(index));
    }
}
