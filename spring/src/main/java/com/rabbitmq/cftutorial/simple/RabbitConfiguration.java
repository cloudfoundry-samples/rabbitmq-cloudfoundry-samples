package com.rabbitmq.cftutorial.simple;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.service.messaging.RabbitServiceCreator;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        return new RabbitServiceCreator(new CloudEnvironment())
                                          .createSingletonService().service;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template;
        try {
            template = new RabbitTemplate(connectionFactory());
            // This sets the routing key for published messages.
            template.setRoutingKey("messages");
            // Where we will synchronously receive messages from
            template.setQueue("messages");
            return template;
        }
        catch (Exception e) {
            throw new AmqpException("Failed to create rabbit template", e);
        }
    }

    @Bean
    public Queue messagesQueue() {
        return new Queue("messages", true);
    }
}
