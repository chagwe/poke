package com.example.poke.congif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PokeApplicationConfig {

    @Autowired
    private Environment env;

    @Bean(name="serviceConfig")
    public PropConfig getPropConfig(){
        return new PropConfig(env.getProperty("poke.endpoint.url"));
    }
}

