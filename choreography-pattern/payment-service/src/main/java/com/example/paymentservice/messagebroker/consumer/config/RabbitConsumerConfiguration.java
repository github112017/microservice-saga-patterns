package com.example.paymentservice.messagebroker.consumer.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.paymentservice.messagebroker.config.RabbitConfiguration;

@Configuration
public class RabbitConsumerConfiguration  extends RabbitConfiguration{

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public SimpleRabbitListenerContainerFactory commonFactory(
			SimpleRabbitListenerContainerFactoryConfigurer configurer) {
		
		SimpleRabbitListenerContainerFactory factory =
				new SimpleRabbitListenerContainerFactory();
		configurer.configure(factory, connectionFactory());
		
		factory.setMessageConverter(jsonMessageConverter());
		
		return factory;
	}
	
}