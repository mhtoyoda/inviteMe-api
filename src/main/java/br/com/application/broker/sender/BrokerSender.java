package br.com.application.broker.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrokerSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String queueName, String message){
		rabbitTemplate.convertAndSend(queueName, message);
	}
}
