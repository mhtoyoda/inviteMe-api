package br.com.application;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:broker.properties")
public class BrokerConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean(name="cachingConnectionFactory")
	public ConnectionFactory connectionFactory() {
	        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(env.getProperty("rabbitmq.host"),Integer.valueOf(env.getProperty("rabbitmq.port")));
	        connectionFactory.setUsername(env.getProperty("rabbitmq.username"));
	        connectionFactory.setPassword(env.getProperty("rabbitmq.password"));
	        connectionFactory.setVirtualHost(env.getProperty("rabbitmq.virtual-host"));	        
	        return connectionFactory;
	    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }
}