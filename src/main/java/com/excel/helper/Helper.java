package com.excel.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.Product;

public class Helper {

	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		else
			return false;
	}
	
	
	// converts excel to list of products
	public static List<Product> convertExcelToListOfProduct(InputStream is){
		List<Product> list = new ArrayList<>();
		
		try {
			
			XSSFWorkbook workbook =  new XSSFWorkbook(is);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			
			while (iterator.hasNext()) {
				Row row = iterator.next();
				
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				
				Product p = new Product();
				Iterator<Cell> cells = row.iterator();
				int cid  = 0;
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch( cid ) {
					case 0:
						p.setProductId((int)cell.getNumericCellValue());
						break;
					case 1 : 
						p.setProductName(cell.getStringCellValue());
						break;
					case 2 : 
						p.setProductPrice(cell.getNumericCellValue());
						break;
					case 3 : 
						p.setProductQty((int)cell.getNumericCellValue());
						break;
					default : 
						break;
					}
					cid++;
					list.add(p);
					System.out.println(list);
				}	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
