package com.example.myfirstspringbootapplication.service.impl;

import com.example.myfirstspringbootapplication.MyFirstSpringBootApplication;
import com.example.myfirstspringbootapplication.service.WebHookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebHookServiceImpl implements WebHookService {
    private static final Logger log = LoggerFactory.getLogger(WebHookServiceImpl.class);

    @Override
    @Async
    public void sendWebHook() {
        RestTemplate restTemplate = new RestTemplate();

        // на сайте http://webhook.site получить ссылку для отправки web-hook
        String resourceUrl = "https://webhook.site/0752a8b2-1831-4b82-9b36-9f56a0b4c745";
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

        log.info("web-hook response: " + response);
    }
}
