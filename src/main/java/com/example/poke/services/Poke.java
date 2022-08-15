package com.example.poke.services;


import com.example.poke.congif.PokeApplicationConfig;
import com.example.poke.congif.PropConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class Poke {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;
    private final PropConfig pokeConfig = (PropConfig) new AnnotationConfigApplicationContext(PokeApplicationConfig.class).getBean("serviceConfig");


    @GetMapping("/getPokeProperties")
    public Object getPoke(){
        String url = pokeConfig.getPokeUrl();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        Object response = restTemplate.exchange(url, HttpMethod.GET,entity,Object.class);
        return response;
    }

    @GetMapping("/getPokeByProperty")
    public Object getPoke(@RequestParam(defaultValue = "all") final String property ) throws Exception {
        if (!property.isEmpty() && property!=null){
            String url =pokeConfig.getPokeUrl()+"/"+property;
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            Object response = restTemplate.exchange(url, HttpMethod.GET,entity,Object.class);
            return response;
        } else {
            throw new Exception("Property does not exist");
        }

    }

}
