package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SampleController {

    private final AmqpTemplate template;

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message) {
        log.info("Emit to myQueue");
        template.convertAndSend("myQueue", message);
        return ResponseEntity.ok("Success emit to queue");
    }
}
