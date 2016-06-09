package br.com.application.broker.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrokerReceiver {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void receiverMessage(String queueName){
		Message message = rabbitTemplate.receive(queueName);
		System.out.println(message.getBody().toString());
	}
}
