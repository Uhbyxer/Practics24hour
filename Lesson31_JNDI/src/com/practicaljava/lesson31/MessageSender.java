package com.practicaljava.lesson31;

import javax.jms.*;
import javax.naming.*;

public class MessageSender {
	public void sendMessage(String messageToSend) {
		Session session = null;
		ConnectionFactory factory = null;
		Connection connection = null;
		
		try{
			
			Context jndiContext = new InitialContext();
			factory = (ConnectionFactory) jndiContext.lookup("MyTestConnectionFactory");
			Queue ioQueue = (Queue) jndiContext.lookup("MyJMSQueue");
			
			connection = factory.createConnection();
			connection.start();
			
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer queueSender = session.createProducer(ioQueue);
			
			TextMessage outMsg = session.createTextMessage(messageToSend);
			queueSender.send(outMsg);
			
			System.out.println("Successfully placed an order to purchase 200 shares of IBM");
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally{
		     try{
		          session.close();
		          connection.close();
		       } catch (Exception e) {
		          System.out.println("Can’t close JMS connection/session " + e.getMessage());
		      }
		}
	}
}
