package com.skywaling.swclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ShaoHuangxing on 2020/6/10
 */
@RestController
@RequestMapping("api")
public class ClientController {

    @Value("${linked.url}")
    private String url;

    @Autowired
    private void initRestTemplate(RestTemplateBuilder builder){
        this.restTemplate=builder.build();
    }

    private RestTemplate restTemplate;

    @GetMapping("/parse")
    public boolean parse() {
        String val = restTemplate.getForObject(url+"/api/returnValue", String.class);
        return !"success".equals(val);
    }
}