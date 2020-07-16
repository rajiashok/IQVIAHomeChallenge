package com.example.demo.service;

import static org.mockito.Mockito.verify;

import javax.jms.Destination;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Message;

@RunWith(SpringJUnit4ClassRunner.class)
public class MessageSchedulerServiceTest {

	@InjectMocks
	MessageSchedulerService messageSchedulerService;
	
	@Mock
	JmsTemplate jmsTemp;
	
	@Captor
	private ArgumentCaptor<MessageCreator> messageCreator;
	private JmsMessagingTemplate messagingTemplate;
	Message m=new Message();
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		messagingTemplate = new JmsMessagingTemplate(jmsTemp);
		m.setMessage("Welcome");
		m.setScheduledTime("15-07-2020 19:07:02");
	}


	@Test
	public void testSendMessage() {
		
		
		Destination destination = new Destination() {};
		
		messagingTemplate.convertAndSend(destination, m);
		
		//when(jmsTemplate.convertAndSend("MessageQueue", m)).thenReturn(1);
		//verify(messagingTemplate).convertAndSend(Mockito.eq("MessageQueue"), messageCreator.capture());
		//Mockito.verify(jmsTemplate).convertAndSend(
			//    Mockito.eq("MessageQueue"), 
			  //  Mockito.any(MessageCreator.class));
		//assertTextMessage(messageCreator.getValue());
	}


}
