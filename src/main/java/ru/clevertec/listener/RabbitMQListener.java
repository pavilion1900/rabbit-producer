package ru.clevertec.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableRabbit
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "myQueue1")
    public void processMyQueue(String message) {
        log.info("Received first from myQueue : {}", message);
    }

    @RabbitListener(queues = "myQueue2")
    public void processMyQueue2(String message) {
        log.info("Received second from myQueue : {}", message);
    }
}
