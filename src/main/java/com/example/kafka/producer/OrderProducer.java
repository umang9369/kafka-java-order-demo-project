package com.example.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import java.util.Properties;
import java.util.Scanner;

public class OrderProducer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter order (or 'exit' to quit): ");
            String order = scanner.nextLine();
            if (order.equalsIgnoreCase("exit")) {
                break;
            }
            producer.send(new ProducerRecord<>("orders", order, order));
            System.out.println("Sent: " + order);
        }

        scanner.close();
        producer.close();
    }
}
