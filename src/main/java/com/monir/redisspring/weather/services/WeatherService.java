package com.monir.redisspring.weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class WeatherService {

    @Autowired
    private ExternalServiceClient client;


    @Cacheable("weather") //this weather will get data from redis
    public int getInfo(int zip){
        return 0;
    }


    @Scheduled(fixedRate = 100_000)  //100 sec
    public void update(){
        System.out.println("updating..");
        IntStream.rangeClosed(1,5).forEach(this.client::getWeatherInfo);
        System.out.println("completed!");
    }

}
