package cn.gsonya.MessageHandler;

import java.sql.SQLException;

public class Receive {
	public static void main(String[] args) {
		Consumer cd=new Consumer();
		cd.getMessage();
		int num=cd.getCount()/4,mark=0;
		while((num--)>0) {
			try {
				mark=JDBCOperation.insert(cd.getExcelCell(),mark);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
