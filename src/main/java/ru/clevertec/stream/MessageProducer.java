package ru.clevertec.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageProducer {

    private final StreamBridge streamBridge;

    @PostMapping("/msg")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        Message<String> msg = MessageBuilder
                .withPayload(message)
                .build();
        streamBridge.send("producer-out-0", msg);
        return ResponseEntity.ok("Message sent");
    }
}
