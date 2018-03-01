package com.studyjar.rabbitmq.realize;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * rabbitmq 监听类
 */
public class AmqpMessageReceiver {

    private final Logger log = LoggerFactory.getLogger(AmqpMessageReceiver.class);

    // 将一个byte数组消息解析成十六进之表示的字符串
    public void receiveMessage(byte[] message) {
        log.info("Received <" + Hex.encodeHexString(message) + ">");
    }

    // 将一个byte数组消息解析成十六进之表示的字符串
    public void receiveMessage(Integer message) {
        log.info("Received <" + message + ">");
    }

    // 将一个byte数组消息解析成十六进之表示的字符串
    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
    }

//    public static void main(String[] args) {
//        AmqpMessageReceiver receiver = new AmqpMessageReceiver();
//        byte[] message = new byte[]{(byte) 243,(byte) 155, (byte) 235, (byte) 200};
//        receiver.receiveMessage(message);
//    }
}
