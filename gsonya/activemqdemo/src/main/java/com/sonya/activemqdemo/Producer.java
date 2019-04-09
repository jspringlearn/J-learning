package com.sonya.activemqdemo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	public static void main(String[] args) throws JMSException
	{
		//1.创建连接工厂
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		//2.获取链接
		Connection connection=connectionFactory.createConnection();
		//3.启动连接
		connection.start();
		//4.获取session
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5.创建队列对象
		Queue queue=session.createQueue("test-queue");
		//6.创建消息生产者
		MessageProducer producer=session.createProducer(queue);
		//7.创建消息
		TextMessage textMessage=session.createTextMessage("欢迎来到mq世界");
		//8.发送消息
		producer.send(textMessage);
		//9.关闭资源
		producer.close();
		session.close();
		connection.close();
	}

}
