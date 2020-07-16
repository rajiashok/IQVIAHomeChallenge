package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Message;

@RunWith(SpringJUnit4ClassRunner.class)
public class MessageReceiverTest {
	@InjectMocks
	MessageReceiver messageReceiver;
	@Mock
	Timer mockedTimer;
	Message m = new Message();

	@Before
	public void setUp() throws Exception {
		m.setMessage("Welcome");
		m.setScheduledTime("16-07-2020 16:49:50");

	}

	@Test
	public void testReceiveMessage() throws ParseException, InterruptedException {
		final CountDownLatch latch = new CountDownLatch(1);
		long diff;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date now = new Date();
		String dN = formatter.format(now);
		Date dateNow = formatter.parse(dN);
		Date dateGiven = formatter.parse(m.getScheduledTime());
		if (dateGiven.compareTo(dateNow) < 0) {
			diff = 0;
		} else {
			diff = dateGiven.getTime() - dateNow.getTime();
		}
		messageReceiver.receiveMessage(m);
		latch.await(diff,TimeUnit.MILLISECONDS);
		
		

	}

}
