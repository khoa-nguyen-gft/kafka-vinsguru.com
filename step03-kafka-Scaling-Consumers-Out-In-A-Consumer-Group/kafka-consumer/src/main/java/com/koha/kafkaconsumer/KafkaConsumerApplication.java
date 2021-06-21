package com.koha.kafkaconsumer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}


@Component
class RandomNumberConsumer {
    
    @Value("${message.processing.time}")
    private long processingTime;
    
    

    @KafkaListener(topics = "first-topic")
    public void consume(String message) throws UnknownHostException, InterruptedException {
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(String.format("%s consumed %s", hostName, message));
        Thread.sleep(processingTime);
    }

}