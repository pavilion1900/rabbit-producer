package ru.clevertec.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class MessageConsumer {

    @Bean
    public Consumer<String> consumer() {
        return (msg) -> {
            log.info("Received the message in Consumer: {}", msg);
        };
    }
}
