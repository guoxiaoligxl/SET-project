package zhouqianqian.dataProvider;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * Excel数据驱动类
 */


public class DataProviders {



	public Object[][] getDataByExcel(String fileName, String sheetName)
			throws IOException {
		File file = new File(fileName);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook wbook = null;
		String fileextensionName = fileName.substring(fileName.indexOf("."));
		if (fileextensionName.equals(".xlsx")) {
			wbook = new XSSFWorkbook(inputstream);
		
		} else if (fileextensionName.equals(".xls")) {
			wbook = new HSSFWorkbook(inputstream);
		}
		Sheet sheet = wbook.getSheet(sheetName);
		// 通过sheetName生成Sheet对象
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		// 获取当前sheet行数，行号和列号都是从０开始
		List<Object[]> records = new ArrayList<Object[]>();
		// 使用双循环获取excel文件的所有数据（第一行除外）
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//获取单元格数据
				XSSFCell cell = (XSSFCell)row.getCell(j);
				cell.setCellType(CellType.STRING);
				fields[j] = cell.getStringCellValue();
			}
			records.add(fields);
		}
		Object[][] result = new Object[records.size()][];
		
		for (int i = 0; i < records.size(); i++) {
			result[i] = records.get(i);
		}
		return result;
	}
	
//	public Object[][] getTestDataByExcel(String fileName, String sheetName)
//			throws IOException {
//		File file = new File(fileName);
//		FileInputStream inputstream = new FileInputStream(file);
//		Workbook wbook = null;
//		String fileExtensionName = fileName.substring(fileName.indexOf("."));
//		if (fileExtensionName.equals(".xlsx")) {
//			wbook = new XSSFWorkbook(inputstream);
//		
//		} else if (fileExtensionName.equals(".xls")) {
//			wbook = new HSSFWorkbook(inputstream);
//		}
//		Sheet sheet = wbook.getSheet(sheetName);
//
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		List<Object[]> records = new ArrayList<Object[]>();
//
//		for (int i = 1; i < rowCount + 1; i++) {
//			Row row = sheet.getRow(i);
//			String fields[] = new String[row.getLastCellNum()];
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				Cell cell = row.getCell(j);
//				cell.setCellType(CellType.STRING);
//				fields[j] = cell.getStringCellValue();
//				
//			}
//			records.add(fields);
//		}
//		Object[][] results = new Object[records.size()][];
//		for (int i = 0; i < records.size(); i++) {
//			results[i] = records.get(i);
//			System.out.println(results[i]);
//		}
//		return results;
//	}
}