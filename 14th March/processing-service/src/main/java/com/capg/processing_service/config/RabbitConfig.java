package com.capg.processing_service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	public static final String Recharge_Queue = "Recharge_Queue";
	public static final String Exchange_Name="Recharge_Exchange";
	public static final String Routing_Key="Recharge_Key";
	
	public static final String Payment_Queue = "Payment_Queue";
	public static final String Routing_Key2="Payment_Key";
	
	public static final String DLQ_Name="DLQ_Queue";
	public static final String DLQ_Exchaneg="DLQ_Exchaneg";
	public static final String DLQ_Key="DLQ_Key";
	
//	@Bean
//	public Queue queue2() {
//		return new Queue(Payment_Queue, true); // false ka mtlb hai queue temporary, and true par queue persistent hai(server restart par bhi rahegi)
//	}
	
	@Bean
	public Queue paymentQueue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-message-ttl", 10000); //10 secs try
		args.put("x-dead-letter-exchange", DLQ_Exchaneg);
		args.put("x-dead-letter-routing-key", DLQ_Key);
		
		return new Queue(Payment_Queue ,true, false, false, args);
	}
	
	@Bean
	public Queue dlq() {
		return new Queue(DLQ_Name, true);
	}
	
	@Bean
	public DirectExchange dlqExchange() {
		return new DirectExchange(DLQ_Exchaneg);
	}
	
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(Exchange_Name);
	}
	
	@Bean
	public Queue rechargeQueue() {
		return new Queue(Recharge_Queue, true); // false ka mtlb hai queue temporary, and true par queue persistent hai(server restart par bhi rahegi)
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(rechargeQueue()).to(exchange()).with(Routing_Key);
	}
	
	@Bean
	public Binding paymentBinding() {
		return BindingBuilder.bind(paymentQueue()).to(exchange()).with(Routing_Key2);
	}
	
	@Bean
	public Binding dlqBinding() {
		return BindingBuilder.bind(dlq()).to(dlqExchange()).with(DLQ_Key);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() { // it will convert producer java message to json and save it to queue. And same happens when it will reach consumer.
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setObservationEnabled(true);   // ADD HERE

        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setObservationEnabled(true);   // ADD HERE

        return factory;
    }

}
