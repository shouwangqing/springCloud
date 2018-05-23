package com.qing.cloud.m1.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

	public static final String QUEUE_NAME="myQueue";
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void publish() {
		amqpTemplate.convertAndSend(QUEUE_NAME,"6666666666666666");
	}
}
