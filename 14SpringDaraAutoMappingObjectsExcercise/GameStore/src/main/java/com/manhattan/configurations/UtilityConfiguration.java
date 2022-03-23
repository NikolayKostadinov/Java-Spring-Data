package com.manhattan.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class UtilityConfiguration {
    @Bean
    public BufferedReader bufferedReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }
}
