package com.practicaljava.lesson30;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageReceiver implements MessageListener{
	private Session session = null;
	private ConnectionFactory factory;
	private QueueConnection connection = null;
	MessageConsumer consumer = null;
	
	public MessageReceiver() {
		try {
			factory = new ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost:7676,mq://localhost:7676");
			connection = factory.createQueueConnection("admin", "admin");
			connection.start();
			
			Session session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue ioQueue = session.createQueue("TestQueue");
			
			consumer = session.createConsumer(ioQueue);
			consumer.setMessageListener(this);
			
			System.out.println("Listening to the TestQueue...");
			Thread.sleep(100000);
			
		} catch(Exception e) {
			System.out.println("error: " + e.getMessage());
		} finally{
			
		       try{
			         // session.close();
			          connection.close();
			       } catch (Exception e) {
			          System.out.println("Can’t close JMS connection/session " + e.getMessage());
			      }
			
		}
	}
	
	public static void main(String[] args) {
		new MessageReceiver();
	}

	public void onMessage(Message msg) {
		String msgText;
		if(msg instanceof TextMessage) {
            try {
				msgText = ((TextMessage) msg).getText();
				System.out.println("Got from the queue: " + msgText);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
		} else {
			System.out.println("Got a non-text message");
		}
		
	}
}
