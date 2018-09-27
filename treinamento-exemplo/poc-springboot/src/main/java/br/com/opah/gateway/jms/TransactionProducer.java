package br.com.opah.gateway.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.opah.gateway.web.vo.JmsContent;

@Service
public class TransactionProducer {

	public static final String TRANSACTION_QUEUE = "transaction-queue";

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * Coloca a mensagem na fila para envio posterior.
	 * 
	 * @param transaction
	 */
	public void sendToQueue(JmsContent jmsContent) {
		jmsTemplate.convertAndSend(TRANSACTION_QUEUE, jmsContent);
	}
}
