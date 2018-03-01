package com.studyjar.rabbitmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * rabbitmq开发：映射文件
 */
@Component
@ConfigurationProperties(prefix = "rabbitmq", ignoreUnknownFields = false)
public class RabbitmqProperties {

    private String hostname = "localhost";

    private int port = 5672;

    private String username = "guest";

    private String password = "guest";

    private String queueName = "spring-boot";

    private String defaultTopicExchange = "sprint-boot-exchange";

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getDefaultTopicExchange() {
        return defaultTopicExchange;
    }

    public void setDefaultTopicExchange(String defaultTopicExchange) {
        this.defaultTopicExchange = defaultTopicExchange;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
