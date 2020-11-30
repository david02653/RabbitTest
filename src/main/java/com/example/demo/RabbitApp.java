package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class RabbitApp {

    private static final String EXCHANGE = "MISCELLANEOUS";

    public static void send(String key, String msg) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("140.121.197.130");
        factory.setPort(9050);

        try(Connection connection = factory.newConnection(); Channel channel = connection.createChannel()){
            channel.exchangeDeclare(EXCHANGE, "topic", true);

            channel.basicPublish(EXCHANGE, key, null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] sent '" + key + "':'" + msg + "'");
        }

    }

}
