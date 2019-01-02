package com.example.paymentservice.messagebroker.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
	
	public static  String QUEUE = "BILLED_ORDER_EVENT";
	
	public static  String EXCHANGE = "billed.order.exchange";
	
	@Bean
	 public ConnectionFactory connectionFactory() {
		 
		 CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		 connectionFactory.setUsername("guest");
		 connectionFactory.setPassword("guest");
		 return connectionFactory;
	 }
	
	@Bean
	public AmqpAdmin amqpAdmin() {
		return  new RabbitAdmin(connectionFactory());
		 
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}