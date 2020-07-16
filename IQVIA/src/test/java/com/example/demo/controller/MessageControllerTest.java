package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Message;
import com.example.demo.model.Status;
import com.example.demo.service.MessageSchedulerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MessageControllerTest {
	@InjectMocks
	MessageController messageController;
	@Mock
	MessageSchedulerService messageSchedulerService;
	private MockMvc mockMvc;
	ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
		

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPushMessagePost() throws Exception {
		Message m = new Message();
		m.setMessage("Welcome IQVIA");
		m.setScheduledTime("15-07-2020 12:10:00");
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(m );
		Status s = new Status();
		s.setStatusCode(202);
		s.setStatusMessage("Accepted");
		Mockito.when(messageSchedulerService.sendMessage(m)).thenReturn(s);
		mockMvc.perform(post("/message/pushv2").content(requestJson).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
				
	}

}
