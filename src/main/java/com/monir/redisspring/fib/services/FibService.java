package com.monir.redisspring.fib.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FibService {

    @Cacheable(value = "math:fib",key = "#idx")
    public int getFib(int idx){
        System.out.println("Calculating fib for "+idx);
        return calculateFib(idx);
    }

    private int calculateFib(int idx){
        if(idx==0 || idx == 1)
            return idx;
        return calculateFib(idx-1)+ calculateFib(idx-2);
    }

    @CacheEvict(value = "math:fib",key = "#index")
    public void clearCache(int index){
        System.out.println("clearing hash keys");
    }

    //All the math:fib related hash value will be removed within 10 seconds time window
    @CacheEvict(value = "math:fib",allEntries = true)
    @Scheduled(fixedRate = 10_000)
    public void clearCacheScheduled(){
        System.out.println("clearing cache keys after 10 seconds");
    }
}
