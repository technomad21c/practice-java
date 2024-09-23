package com.example.sessiontest.sse.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Service
public class KnowledgeService {

    @Autowired
    private WebClient webClient;

    Logger logger = LoggerFactory.getLogger(KnowledgeService.class);


    public String requestKnowledge(HashMap<String, String> kr, SseEmitter sseEmitter) throws IOException {
        logger.info("--- Sending a request to Knowledge Provider");
        logger.info("Request Body: " + kr.toString());
//        String response = webClient.post()
//                .uri("/knowledge")
//                .body(BodyInserters.fromValue(kr)).retrieve().bodyToMono(String.class).block();
//        logger.info("--- received knowledge from Knowledge Provider");
//        logger.info("Knowledge: " + response);
        String response = "{ APIDetails: {} }";
        sseEmitter.send(kr.toString());
        return kr.toString();
    }

    public String requestKnowledge2(HashMap<String, String> kr) {
        logger.info("--- Sending a request to Knowledge Provider");
        logger.info("Request Body: " + kr.toString());
//        String response = webClient.post()
//                .uri("/knowledge")
//                .body(BodyInserters.fromValue(kr)).retrieve().bodyToMono(String.class).block();
//        logger.info("--- received knowledge from Knowledge Provider");
//        logger.info("Knowledge: " + response);
        String response = kr.toString();
        return response;
    }


}
