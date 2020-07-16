package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Message;
import com.example.demo.util.PrintMessage;

@Component
public class MessageReceiver {

	@JmsListener(destination = "MessageQueue", containerFactory = "myFactory")
	public void receiveMessage(Message msg) throws ParseException, InterruptedException {
		
		Timer timer = new Timer();
		long diff;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date now = new Date();
		String dN = formatter.format(now);
		Date dateNow = formatter.parse(dN);
		Date dateGiven = formatter.parse(msg.getScheduledTime());
		if (dateGiven.compareTo(dateNow) < 0) {
			diff = 0;
		} else {
			diff = dateGiven.getTime() - dateNow.getTime();
		}
		timer.schedule(new PrintMessage(msg.toString()), diff);
		
	}

}
