package cn.gsonya.MessageHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//获取workbook
public class ExcelUtil {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	private static int cellNum;//列数
	private static int rowNum;//行数
	private static String[] excelCell=new String[3000];//保存单元格数据
	public static int getCellNum() {
		return cellNum;
	}
	public static int getRowNum() {
		return rowNum;
	}
	public static String[] getExcelCell() {
		return excelCell;
	}
	public static Workbook getWorkbook(InputStream in,File file) throws IOException {
		Workbook wb=null;//HSSFWorkbook的实现类
		//endsWith()测试此字符串是否以指定的后缀结尾。
		if(file.getName().endsWith(EXCEL_XLS)) {
			wb=new HSSFWorkbook(in);
		}else if(file.getName().endsWith(EXCEL_XLSX)){
			wb=new XSSFWorkbook(in);
		}
		return wb;
	}
	//判断是否是Excel文件
	public static void checkExcelVaild(File file) throws Exception {
		if(!file.exists()) {
			throw new Exception("文件不存在！");
		}
		if(!(file.isFile()&&(file.getName().endsWith(EXCEL_XLS)||file.getName().endsWith(EXCEL_XLSX)))) {
			throw new Exception("文件不是Excel文件!");
		}
	}
	//返回单元格的值
	private static Object getValue(Cell cell) {
		Object obj=null;
		switch(cell.getCellType()) {
		case BOOLEAN:
			obj=cell.getBooleanCellValue();break;
		case FORMULA:
			obj=cell.getCellFormula();break;
		case STRING:
			obj=cell.getStringCellValue();break;
		case NUMERIC:
			obj=cell.getDateCellValue();break;
			default:
				break;
		}
		return obj;
	}
	public static void disPlayRow(Workbook workbook) {
		//遍历第一个sheet
		Sheet sheet=workbook.getSheetAt(0);
		//跳过第一行目录(列标识)
		int count=0,mark=0;
		cellNum=0;rowNum=0;
		for(Row row:sheet) {
			if(count<1) {
				count++;
				continue;
			}
			if(row.getCell(0)==null) {
				return;
			}
			//获得列数
			cellNum=row.getLastCellNum();
			//不扫描空列
			int end=row.getLastCellNum();
			for(int i=0;i<end;i++) {
				Cell cell=row.getCell(i);
				if(cell==null) {
					excelCell[mark++]=null;
					continue;
				}
				Object obj=getValue(cell);
				excelCell[mark++]=obj+"";
			}
			rowNum++;
		}
	}
	public static void main(String[] args) throws Exception {
		File excelFile=new File("E:\\Study\\software172_Student");
		FileInputStream in=new FileInputStream(excelFile);
		checkExcelVaild(excelFile);
		Workbook workbook=getWorkbook(in,excelFile);
		disPlayRow(workbook);
	}

}
