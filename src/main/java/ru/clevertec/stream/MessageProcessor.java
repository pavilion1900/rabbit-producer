package ru.clevertec.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class MessageProcessor {

    @Bean
    public Function<String, String> processor() {
        return (msg) -> {
            log.info("Printing from processor");
            return msg.toUpperCase() + ": Message is processed";
        };
    }
}
