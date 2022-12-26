package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SampleController {

    private final RabbitTemplate template;

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody Map<String, String> map) {
        log.info("Emit to myQueue");
        template.setExchange("topic-exchange");
        template.convertAndSend(map.get("key"), map.get("message"));
        return ResponseEntity.ok("Success emit to queue");
    }
}
