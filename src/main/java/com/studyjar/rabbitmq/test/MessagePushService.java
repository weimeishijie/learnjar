package com.studyjar.rabbitmq.test;

import com.studyjar.rabbitmq.config.RabbitmqProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class MessagePushService {

    public static final String EXCHANGE = "amq.topic";
    public static final String ROUTING_KEY = "amq.topic.";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitmqProperties rabbitmqProperties;

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePushService.class);

    public boolean sendMessage(String topic, byte[] message) {
        try {
//            this.rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY + topic, message);// 用的是已经存在的交换机
            this.rabbitTemplate.convertAndSend(rabbitmqProperties.getDefaultTopicExchange(), ROUTING_KEY + topic, message);// 用自己新建的交换机
            return true;
        } catch (Exception ex) {
            //Logging.
            LOGGER.error("Error sent messge: ", ex);
        }
        return false;
    }


}
