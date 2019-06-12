package activemq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

	public void sendTextMessage(String data) {
		//连接工厂
		ConnectionFactory factory=null;
		//连接
		Connection connection=null;
		//目的地
		Destination destination=null;
		//会话
		Session session=null;
		//消息发送
		MessageProducer producer=null;
		//消息
		Message message=null;
		
		try {
			factory=new ActiveMQConnectionFactory("tcp://148.70.79.191:17152");
			connection =factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			destination= session.createTopic("test-1");		
			producer =session.createProducer(destination);
			message=session.createTextMessage(data);
			producer.send(message);
			System.out.println("消息已发送！！！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(producer !=null) {
				try {
					session.close();
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
		
	}
    public static String readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;
        String result =null;
        try {   
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null; 
           
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                result =result+tempString+"\n";
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }
        return result;
    }  
	public static void main(String[] args) {
		String fileName="D:\\test.txt";
		Sender sender =new Sender();
		String data =readFileByLines(fileName);
		sender.sendTextMessage(data);
	}
}
