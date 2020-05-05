package com.excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readwriteExcel
{
	  
	    XSSFWorkbook workbook;
	    XSSFSheet sheet;
	    XSSFCell cell;
	 

	 public void ReadData(String username,String password) throws IOException
	 {
	     // Import excel sheet.
	     File src=new File("C:\\Users\\Sudhakar\\eclipse-workspace\\Linkedin1\\src\\test\\resources\\TestData\\linkedinlogin.xlsx");
	      
	     // Load the file.
	     FileInputStream finput = new FileInputStream(src);
	      
	     // Load he workbook.
	    workbook = new XSSFWorkbook(finput);
	      
	     // Load the sheet in which data is stored.
	     sheet= workbook.getSheetAt(0);
	      int i;
	     
	     for( i=1; i<=sheet.getLastRowNum(); i++)
	     {
	         // Import data for Email.
	         cell = sheet.getRow(i).getCell(1);
	         cell.setCellType((CellType.STRING));
	         username=cell.getStringCellValue();
	         
	          
	         // Import data for password.
	         cell = sheet.getRow(i).getCell(2);
	         cell.setCellType(CellType.STRING);
	        password= cell.getStringCellValue();
	        
	         // Write data in the excel.
	       FileOutputStream foutput=new FileOutputStream(src);
	         
	        // Specify the message needs to be written.
	        String message = "Data Imported Successfully.";
	         
	        // Create cell where data needs to be written.
	        sheet.getRow(i).createCell(3).setCellValue(message);
	          
	        // Specify the file in which data needs to be written.
	        FileOutputStream fileOutput = new FileOutputStream(src);
	         
	        // finally write content
	        workbook.write(fileOutput);
	         
	         // close the file
	        fileOutput.close();
	       
	             
	     }
	     //return username;
	       // return password;
	 } 
}
