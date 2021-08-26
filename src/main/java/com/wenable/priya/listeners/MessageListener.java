package com.wenable.priya.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.wenable.priya.configuration.RabbitMQConfig;

@Component
public class MessageListener {

	@RabbitListener(queues= RabbitMQConfig.QUEUE)
	public void consumer( String message)
	{
		try {
			process(message);
		}
		catch(Exception e)
		{
			
		}
	}

	private void process(String message) {
		System.out.println("Message recevied: "+ message);		
	}
}
