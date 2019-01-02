package com.example.orderservice.messagebroker.producer.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.orderservice.messagebroker.config.RabbitConfiguration;

@Configuration
public class ProducerConfiguration extends RabbitConfiguration {

	@Bean
	Queue queue() {
		return new Queue(QUEUE);
	}
	
	@Bean
	List<Binding> bindings() {

	    return Arrays.asList(BindingBuilder.bind(queue()).to(exchange()).with(QUEUE));
	    
	}
	
	@Bean
	DirectExchange exchange() {
	
		return new DirectExchange(EXCHANGE);
	}
		
	@Bean
	public RabbitTemplate rabbitTemplate() {
		
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey(QUEUE);
		 
		rabbitTemplate.setExchange(EXCHANGE);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		// RabbiMQ will use on going transaction 
		rabbitTemplate.setChannelTransacted(true); 
		return rabbitTemplate;
	}
	
}
