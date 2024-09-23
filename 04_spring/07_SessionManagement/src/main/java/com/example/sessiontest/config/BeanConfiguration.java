package com.example.sessiontest.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class BeanConfiguration {
    // Creating an object for Faker.
    @Bean
    public Faker faker() {
        return new Faker(new Locale("en-US"));
    }

    // Creating an object for SseEmitter.
    @Bean
    public SseEmitter sseEmitter() {
        return new SseEmitter();
    }

    // Creating an object for ExecutorService.
    @Bean
    public ExecutorService executorService() {
        return Executors.newSingleThreadExecutor();
    }
}
