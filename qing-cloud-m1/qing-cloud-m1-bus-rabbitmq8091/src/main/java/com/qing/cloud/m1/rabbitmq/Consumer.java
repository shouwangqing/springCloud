package com.qing.cloud.m1.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "myQueue")
public class Consumer {
	private final static Logger LOG=LoggerFactory.getLogger(Consumer.class);
	
	@RabbitHandler
	public void consume(String msg) {
		LOG.info("啊啊啊啊:"+msg);
	}
}
