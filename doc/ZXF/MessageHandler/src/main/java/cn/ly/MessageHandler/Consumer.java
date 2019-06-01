package cn.gsonya.MessageHandler;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	private int count=0;
	private String[] excelCell=new String[1000];
	private ActiveMQConnectionFactory connFactory;
	private Connection conn;
	private Session session;
	private Destination destination;
	private MessageConsumer consumer;
	public int getCount() {
		return count;
	}
	public String[] getExcelCell() {
		return excelCell;
	}
	Consumer(){
		connFactory=new ActiveMQConnectionFactory("admin","admin","tcp://127.0.0.1:61616");
		try {
			conn=connFactory.createConnection();
			conn.start();
			session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getMessage() {
		try {
			destination=session.createQueue("testQueue");
			consumer=session.createConsumer(destination);
			System.out.println("Consumer接收消息");
			String ms=null;
			while(true) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				TextMessage msg=(TextMessage)consumer.receive(5000);
				if(msg!=null) {
					ms=msg.getText();
					System.out.println("Consumer:"+ms);
					excelCell[count++]=ms;
				}else {
					break;
				}
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				consumer.close();
				session.close();
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		Consumer cd=new Consumer();
		cd.getMessage();
	}

}
