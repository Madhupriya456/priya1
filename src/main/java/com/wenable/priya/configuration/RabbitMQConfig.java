package com.wenable.priya.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	public static final String QUEUE = "queue";
	public static final String EXCHANGE = "exchange";
	public static final String ROUTING_KEY = QUEUE;
	
	@Bean
	public DirectExchange direct()
	{
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	public Queue updateQueue() {
		return new Queue(QUEUE);
	}
	
	@Bean
	public Binding updateBinding() {
		return BindingBuilder.bind(updateQueue()).to(direct()).with(ROUTING_KEY);
	}
	
}
