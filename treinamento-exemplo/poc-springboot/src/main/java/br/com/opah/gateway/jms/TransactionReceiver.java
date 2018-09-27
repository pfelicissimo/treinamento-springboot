package br.com.opah.gateway.jms;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.opah.gateway.web.vo.JmsContent;

/**
 * Process the transaction.
 * 
 * @author carlosabreu
 * 
 */
@Component
public class TransactionReceiver {

	public static final String TRANSACTION_QUEUE = "transaction-queue";

	@JmsListener(destination = TRANSACTION_QUEUE)
	public void receiveMessage(@Payload JmsContent jmsContent,
			@Headers MessageHeaders headers, Message message, Session session) {

		System.out.println(jmsContent.getData());
	}

}