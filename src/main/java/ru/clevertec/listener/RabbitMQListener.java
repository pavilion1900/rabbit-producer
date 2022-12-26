package ru.clevertec.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableRabbit
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "myQueue")
    public void processMyQueue(String message) {
        log.info("Received from myQueue : {}", message);
    }
}
