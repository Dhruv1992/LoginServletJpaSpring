package com.antra.config;

import java.util.Arrays;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessageConfig {

	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	
	private static final String ORDER_QUEUE = "order-queue";
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.antra"));
		
		return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName(ORDER_QUEUE);
		
		return jmsTemplate;
	}
}
