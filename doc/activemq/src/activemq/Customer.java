package activemq;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import entity.Student;
import entity.StudentDao;

public class Customer {

	public String receiveTextMessage() {
		String result= null;
		ConnectionFactory factory=null;
		Connection connection=null;
		Session session=null;
		Destination destination=null;
		MessageConsumer consumer=null;
		Message message=null;
		try {
			factory =new ActiveMQConnectionFactory("tcp://148.70.79.191:17152");
			connection =factory.createConnection();
			connection.start();
			session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination=session.createTopic("test-1");
			consumer =session.createConsumer(destination);
			message=consumer.receive();
			result=((TextMessage)message).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(consumer !=null) {
				try {
					consumer.close();
				} catch (JMSException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(session !=null) {
				try {
					session.close();
				} catch (JMSException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public static void main(String[] arg) {
		Customer customer=new Customer();
		String  message =customer.receiveTextMessage();
		System.out.println("消息内容是:\n"+message);
		System.out.println("开始传入数据库");
		String[] tmp=message.split("\\s+");
		int i=1;
		StudentDao studentDao=new StudentDao();
		while (i<tmp.length) {
					
			Student student=new Student();
			student.setGrade(tmp[i]);
			++i;
			student.setMajor(tmp[i]);
			++i;
			student.setCla(tmp[i]);
			++i;
			student.setCpeople(tmp[i]);
			++i;
			student.setNumber(tmp[i]);
			++i;
			student.setName(tmp[i]);
			++i;
			student.setSex(tmp[i]);
			++i;
			studentDao.add(student);
		}
		System.out.println("传输成功！！！");
	}
		
	
}
