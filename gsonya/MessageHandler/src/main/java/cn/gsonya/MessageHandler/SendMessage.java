package cn.gsonya.MessageHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;

public class SendMessage {
	
	public static void main(String[] args) throws Exception {
		//�����ļ�����
		File excelFile=new File("E:\\Study\\software172_Student.xlsx");
		FileInputStream input=new FileInputStream(excelFile);
		//�ж��Ƿ���Excel�ļ�
		ExcelUtil.checkExcelVaild(excelFile);
		Workbook workbook=ExcelUtil.getWorkbook(input, excelFile);
		ExcelUtil.disPlayRow(workbook);
		Producer cd=new Producer();
		cd.sendMessageExcel(ExcelUtil.getCellNum()*ExcelUtil.getRowNum(),ExcelUtil.getExcelCell());
		
	}

}
