package cn.gsonya.MessageHandler;

public class Message {
	public static void main(String[] args) {
		Producer producer=new Producer();
		Consumer consumer=new Consumer();
		producer.sendMessage();
		consumer.getMessage();
	}

}
class ProducerThread extends Thread{
	@Override
	public void run() {
		Producer cd=new Producer();
		cd.sendMessage();
	}
}
class ConsumerThread extends Thread{
	@Override
	public void run() {
		Consumer cd=new Consumer();
		cd.getMessage();
	}
}
