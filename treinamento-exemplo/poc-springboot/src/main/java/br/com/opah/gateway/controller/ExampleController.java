package br.com.opah.gateway.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.gateway.jms.TransactionProducer;
import br.com.opah.gateway.jms.TransactionReceiver;
import br.com.opah.gateway.web.vo.JmsContent;

@RestController()
@RequestMapping("example")
public class ExampleController {

	@Autowired
	private TransactionProducer transactionProducer;
	
	@Autowired
	private TransactionReceiver transactionReceiver;

	@PostMapping
	public void create(HttpServletRequest request, @RequestBody String data) {
		JmsContent jmsContent = new JmsContent();
		jmsContent.setData(data);
		transactionProducer.sendToQueue(jmsContent);
		
	
	}

}
