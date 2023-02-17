package com.donglin.rabbitmq.simple;

import com.donglin.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;
import java.io.IOException;

import com.rabbitmq.client.*;
import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queue2Name = "test_topic_queue2";
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body："+new String(body));
            }
        };
        channel.basicConsume(queue2Name,true,consumer);
    }
}