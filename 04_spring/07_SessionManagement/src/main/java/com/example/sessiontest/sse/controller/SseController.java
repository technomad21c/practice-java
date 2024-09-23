package com.example.sessiontest.sse.controller;


import com.example.sessiontest.sse.model.Emp;
import com.example.sessiontest.sse.service.EmpService;
import com.example.sessiontest.sse.service.KnowledgeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@RestController
public class SseController {

    @Autowired
    private EmpService service;
    @Autowired
    private SseEmitter sseEmitter;
    @Autowired
    private ExecutorService executorService;
    @Autowired
    private KnowledgeService knowledgeService;

    @GetMapping("/stream-sse")
    public Flux<ServerSentEvent<String>> streamEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String> builder()
                        .id(String.valueOf(sequence))
                        .event("periodic-event")
                        .data("SSE - " + LocalTime.now().toString())
                        .build());
    }

    @GetMapping("/sse")
    public SseEmitter sendProgress() throws InterruptedException, IOException {
        log.info("pushing the progress to a client");

        SseEmitter se = new SseEmitter();

        SseEmitter.SseEventBuilder event = SseEmitter.event()
                    .data("SSE MVC - " + LocalTime.now().toString())
                    .id(String.valueOf(1))
                    .name("sse event - mvc");
        se.send(event);

//        for (int i=0; i < 10; i++) {
//            SseEmitter.SseEventBuilder event = SseEmitter.event()
//                    .data("SSE MVC - " + LocalTime.now().toString())
//                    .id(String.valueOf(i))
//                    .name("sse event - mvc");
//            se.send(event);
//            Thread.sleep(1000);
//        }

//        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
//        sseMvcExecutor.execute(() -> {
//            try {
//                for (int i = 0; true; i++) {
//                    SseEmitter.SseEventBuilder event = SseEmitter.event()
//                            .data("SSE MVC - " + LocalTime.now().toString())
//                            .id(String.valueOf(i))
//                            .name("sse event - mvc");
//                    se.send(event);
//                    Thread.sleep(1000);
//                }
//            } catch (Exception ex) {
//                se.completeWithError(ex);
//            }
//        });

        Thread.sleep(5000);
        sseEmitter.complete();
        return se;
    }

    // URL - http://localhost:10093/emit-data-items
    @GetMapping("/emit-data-items")
    public SseEmitter fetchData() throws ExecutionException, InterruptedException {
        log.info("Emitting the employee data sets.");

        Callable<String> task1 = () -> {
            HashMap<String, String> knowledgeRequest = new HashMap<>();
            TimeUnit.MILLISECONDS.sleep(300);
            knowledgeRequest.put("\"KnowledgeType\"", "\"1.1\"");
            knowledgeRequest.put("\"NodeType\"", "\"SRC_N\"");
            knowledgeRequest.put("\"Vendor\"", "\"Druid\"");
            knowledgeRequest.put("\"Version\"", "\"v5.2.3.0-1\"");
            log.info("--- starting knowledge request");
            String knowledge = knowledgeService.requestKnowledge(knowledgeRequest, sseEmitter);
            return knowledge;
        };
        Callable<String> task2 = () -> {
            HashMap<String, String> knowledgeRequest = new HashMap<>();
            TimeUnit.MILLISECONDS.sleep(300);
            knowledgeRequest.put("\"KnowledgeType\"", "\"1.2\"");
            knowledgeRequest.put("\"NodeType\"", "\"SRC_N\"");
            knowledgeRequest.put("\"Vendor\"", "\"Druid\"");
            knowledgeRequest.put("\"Version\"", "\"v5.2.3.0-1\"");
            log.info("--- starting knowledge request");
            String knowledge = knowledgeService.requestKnowledge(knowledgeRequest, sseEmitter);
            return knowledge;
        };
        Callable<String> task3 = () -> {
            HashMap<String, String> knowledgeRequest = new HashMap<>();
            TimeUnit.MILLISECONDS.sleep(300);
            knowledgeRequest.put("\"KnowledgeType\"", "\"1.3\"");
            knowledgeRequest.put("\"NodeType\"", "\"SRC_N\"");
            knowledgeRequest.put("\"Vendor\"", "\"Druid\"");
            knowledgeRequest.put("\"Version\"", "\"v5.2.3.0-1\"");
            log.info("--- starting knowledge request");
            String knowledge = knowledgeService.requestKnowledge(knowledgeRequest, sseEmitter);
            return knowledge;
        };

        for (int i=0; i<10; i++) {
            Thread.sleep(1000);
            System.out.printf("[%2d] task1\n", i);
            Future<String> future1 = executorService.submit(task1);
            Thread.sleep(1000);
            System.out.printf("[%2d] task2\n", i);
            Future<String> future2 = executorService.submit(task2);
            Thread.sleep(1000);
            System.out.printf("[%2d] task3\n", i);
            Future<String> future3 = executorService.submit(task3);

            String k1 = future1.get();
            String k2 = future2.get();
            String k3 = future3.get();
        }


        sseEmitter.complete();
        /*
        executorService.execute(() -> {
            // Fetching the employees from the dB.
            final List<Emp> employees = service.findAll();
            try {
                for (final Emp employee : employees) {
                    randomDelay();
                    HashMap<String, String> knowledgeRequest = new HashMap<>();
                    knowledgeRequest.put("\"KnowledgeType\"", "\"1.2\"");
                    knowledgeRequest.put("\"NodeType\"", "\"SRC_N\"");
                    knowledgeRequest.put("\"Vendor\"", "\"Druid\"");
                    knowledgeRequest.put("\"Version\"", "\"v5.2.3.0-1\"");
                    log.info("--- starting knowledge request");
                    String knowledge = knowledgeService.requestKnowledge(knowledgeRequest);
                    // Sending the employee details in the emitter event.
                    sseEmitter.send(knowledge);
                }
                // The request processing is completed so that the responsible thread can complete
                // the request and be freed up for the next response to handle.

                sseEmitter.complete();
                log.info("--- completed knowledge request");
            } catch (final IOException e) {
                log.info("IO exception occurred while emitting the employee data sets.");
                // In case of any error while processing the request, complete the process and pass the
                // exception through the normal exception handling of Spring MVC framework and after that
                // response is completed.
                sseEmitter.completeWithError(e);
            }
        });

        executorService.execute(() -> {
            // Fetching the employees from the dB.
            final List<Emp> employees = service.findAll();
            try {
                for (final Emp employee : employees) {
                    randomDelay();
                    HashMap<String, String> knowledgeRequest = new HashMap<>();
                    knowledgeRequest.put("\"KnowledgeType\"", "\"1.2\"");
                    knowledgeRequest.put("\"NodeType\"", "\"SRC_N\"");
                    knowledgeRequest.put("\"Vendor\"", "\"Druid\"");
                    knowledgeRequest.put("\"Version\"", "\"v5.2.3.0-1\"");
                    log.info("--- starting knowledge request");
                    String knowledge = knowledgeService.requestKnowledge2(knowledgeRequest);
                    // Sending the employee details in the emitter event.
                    sseEmitter.send(knowledge);
                }
                // The request processing is completed so that the responsible thread can complete
                // the request and be freed up for the next response to handle.

                sseEmitter.complete();
                log.info("--- completed knowledge request");
            } catch (final IOException e) {
                log.info("IO exception occurred while emitting the employee data sets.");
                // In case of any error while processing the request, complete the process and pass the
                // exception through the normal exception handling of Spring MVC framework and after that
                // response is completed.
                sseEmitter.completeWithError(e);
            }
        });
//        executorService.shutdown();

         */
        return sseEmitter;
    }

    // Private method to put a random delay in between the records.
    private void randomDelay() {
        try {
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            log.info("Thread is interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
