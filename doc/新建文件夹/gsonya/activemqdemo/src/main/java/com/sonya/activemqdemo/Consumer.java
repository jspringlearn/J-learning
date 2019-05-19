package com.sonya.activemqdemo;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;

public class Consumer {
	public static void main(String[] args) throws JMSException, IOException {
		//1.创建连接工厂
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		//2.获取连接
		Connection connection=connectionFactory.createConnection();
		//3.启动连接
		connection.start();
		//4.获取session
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5.创建队列对象
		Queue queue=session.createQueue("test-queue");
		//6.创建消息消费者
		MessageConsumer consumer=session.createConsumer(queue);
		//7.监听消息
		consumer.setMessageListener(new MessageListener() {
			//@Override
			public void onMessage(Message message) {
				TextMessage textMessage=(TextMessage)message;
				try {
					System.out.println("接收到消息："+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void onMessage(javax.jms.Message message) {
				// TODO Auto-generated method stub
				
			}
		});
		//8.等待键盘键入
		System.in.read();
		//9.关闭资源
		consumer.close();
		session.close();
		connection.close();
	}

}
