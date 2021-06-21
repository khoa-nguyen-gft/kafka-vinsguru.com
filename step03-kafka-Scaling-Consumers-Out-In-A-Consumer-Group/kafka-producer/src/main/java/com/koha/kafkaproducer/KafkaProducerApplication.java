package com.koha.kafkaproducer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

}


@Component
class RandomNumberProducer {

    private static final int MIN = 10;
    private static final int MAX = 100_000;
    private int counter = 1;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 1000)
    public void produce() throws UnknownHostException {
        int random = counter++;
        this.kafkaTemplate.sendDefault(String.valueOf(random));
        //just for logging
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(String.format("%s produced %d", hostName, random));
    }

}