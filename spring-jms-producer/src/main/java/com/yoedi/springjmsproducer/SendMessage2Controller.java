package com.yoedi.springjmsproducer;

import com.yoedi.springjmsproducer.configuration.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessage2Controller {

    private final String queueName = "MESSAGE_QUEUE_2";

    @Autowired
    JmsProducer jmsProducer;

    @GetMapping("/send2")
    public String sendMessage() {
        jmsProducer.sendMessage(queueName,"Hello World");
        return "Send message success";
    }

}
