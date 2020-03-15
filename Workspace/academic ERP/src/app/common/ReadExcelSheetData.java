package app.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetData {
	
	public void readExcelSheet(String strFilePath) throws IOException
	{
		strFilePath = strFilePath.replace("\\\\", "\\");
		File check_file = new File(strFilePath);
		if(check_file.exists())
		{
			System.out.println("FILE EXISTS");
		}
	
	try 
	{
		File myFile = new File(strFilePath);
		FileInputStream fis = new FileInputStream(myFile); 
		org.apache.poi.xssf.usermodel.XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator();
		while (rowIterator.hasNext()) 
			{ 
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
				 {
		          Cell cell = cellIterator.next();
		          System.out.print(cell.toString()+"\t");
		      
				  
		    }
			 System.out.println("");
		}
	}
	catch (Exception e) 
	{
	        System.err.println("Exception :" + e.getMessage());
	}
	}
	}