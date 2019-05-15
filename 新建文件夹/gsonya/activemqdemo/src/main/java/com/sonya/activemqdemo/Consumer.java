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
		//1.�������ӹ���
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		//2.��ȡ����
		Connection connection=connectionFactory.createConnection();
		//3.��������
		connection.start();
		//4.��ȡsession
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5.�������ж���
		Queue queue=session.createQueue("test-queue");
		//6.������Ϣ������
		MessageConsumer consumer=session.createConsumer(queue);
		//7.������Ϣ
		consumer.setMessageListener(new MessageListener() {
			//@Override
			public void onMessage(Message message) {
				TextMessage textMessage=(TextMessage)message;
				try {
					System.out.println("���յ���Ϣ��"+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void onMessage(javax.jms.Message message) {
				// TODO Auto-generated method stub
				
			}
		});
		//8.�ȴ����̼���
		System.in.read();
		//9.�ر���Դ
		consumer.close();
		session.close();
		connection.close();
	}

}
