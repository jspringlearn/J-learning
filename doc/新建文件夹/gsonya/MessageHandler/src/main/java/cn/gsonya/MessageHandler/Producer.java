package cn.gsonya.MessageHandler;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	
	private static ActiveMQConnectionFactory connFactory;
	private static Connection conn;
	private static Session session;
	private static Destination destination;
	private static MessageProducer producer;

	Producer(){
		//�������ӹ���
		 connFactory = new ActiveMQConnectionFactory("admin","admin","tcp://127.0.0.1:61616");
		 //��ȡ����
		 try {
			conn=connFactory.createConnection();
			conn.start();
			session=conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage() {
		boolean result=false;
		//����һ����Ϣ����p2p��
		try {
			destination=session.createQueue("testQueue");
			//pub/sub:destination=session.createTopic("textTopic");
		    producer=session.createProducer(destination);
		    //��Ϣ�־û�
		    producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		    if(null!=session&&null!=producer) {
		    	String message="hello javaee!";
		    	int count=11;
		    	System.out.println("Producer��ʼ������Ϣ!");
		    	while((count--)>1) {
		    		Thread.sleep(500);
		    		producer.send(session.createTextMessage("message"+count+":"+message));
		    		System.out.println("Producer:"+"message"+count+":"+message);
		    		session.commit();
		    		result=true;
		    	}
		    }
		    
		
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				producer.close();
				session.close();
			    conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(result?"Producer:��Ϣ���ͳɹ���\n":"Producer:��Ϣ����ʧ�ܣ�\n");	
	}
	public void sendMessageExcel(int count,String[] excelCell) {
		boolean result=false;
		try {
			destination=session.createQueue("testQueue");
			producer=session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			if(null!=session&&null!=producer) {
				System.out.println("Producer��ʼ������Ϣ��");
				int n=0;
				while(n<count) {
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					producer.send(session.createTextMessage(excelCell[n]));
					System.out.println("Producer:"+excelCell[n]);
					n++;
					session.commit();
					result=true;
				}
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				producer.close();
				session.close();
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(result?"producer:��Ϣ���ͳɹ���\n":"Producer:��Ϣ����ʧ�ܣ�\n");
		
	}
	public static void main(String[] args) {
		Producer cd=new Producer();
		cd.sendMessage();
	}

}
