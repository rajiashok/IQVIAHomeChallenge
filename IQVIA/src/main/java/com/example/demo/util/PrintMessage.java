package com.example.demo.util;

import java.util.Date;
import java.util.TimerTask;

public class PrintMessage extends TimerTask{

	String message;
	public PrintMessage(String m) {
		
		this.message=m;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date+":"+this.message);	
	}



}
