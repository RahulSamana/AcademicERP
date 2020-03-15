package webapp.exchange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.IOException;
import java.util.ArrayList;

import app.common.ReadExcelSheetData;
import app.library.ManageLibrary;
import app.register.ManageRegistration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Library {
	private static Properties properties = null;
	public String addNewBook( ArrayList<String> fieldNames, ArrayList<String> fieldValues)  throws IOException 
	{
		String result ="false";
		app.library.Library obj = new app.library.Library();
		for(int i=0;i<fieldNames.size();i++)
		 {	 
			 if(fieldNames.get(i).equalsIgnoreCase("reference-number-of-book"))
			 {
				 obj.setsUniqueReferenceNumber(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("book-name"))
			 {
				 obj.setsBookName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("author-name-1"))
			 {
				 obj.setsAuthor1(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("author-name-2"))
			 {
				 obj.setsAuthor2(fieldValues.get(i)); 
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("author-name-3"))
			 {
				 obj.setsAuthor3(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("course-name"))
			 {
				 obj.setsCourseName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("sub-course-name"))
			 {
				 obj.setsSubCourseName(fieldValues.get(i));
			 }
			 obj.setsIssuedStatus("available");
		 }
		app.library.ManageLibrary objManage = new ManageLibrary();
		result = objManage.Insert(obj);		 
		return result;
	}
	
	 public void readExcelSheet(String strFilePath) throws IOException
	 {
		 app.common.ReadExcelSheetData read = new ReadExcelSheetData();
		 read.readExcelSheet(strFilePath);
	 }
	 public void deleteExistingFile(String strFilePath) throws IOException
	 {
		 File file = new File(strFilePath);
		 if(file.exists())
		 {
			 FileUtils.deleteQuietly(new File(strFilePath)); 
		 }
		 else 
		 {
			 return;
		 }
		
	 }
	 public List<app.library.Library> getBooksWithReferenceNumber(String strReferenceNumber)
	 {
		 List<app.library.Library> result = null;
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result = objManage.getBooksWithReferenceNumber(strReferenceNumber);
		 return result;
	 }
	 
	 public List<app.library.Library> getBooksWithRollNumber(String strRollNumber)
	 {
		 List<app.library.Library> result = null;
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result = objManage.getBooksWithRollNumber(strRollNumber);
		 return result;
	 }
	 
	 public List<app.library.Library> getBooksWithBookName(String strBookName)
	 {
		 List<app.library.Library> result = null;
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result = objManage.getBooksWithBookName(strBookName);
		 return result;
	 }
	 
	 public List<app.library.Library> getBooksWithAuthorName(String strAuthorName)
	 {
		 List<app.library.Library> result = null;
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result = objManage.getBooksWithAuthorName(strAuthorName);
		 return result;
	 }
	 
	 public String issueLibraryBookToStudent(String strBookReferenceNumber, String strStudentRollNumber,String strDateOfIssue,String strRenewalDate)
	 {
		 String result = "false";
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result =  objManage.issueLibraryBookToStudent(strBookReferenceNumber,strStudentRollNumber,strDateOfIssue,strRenewalDate);
		 
		 return result;
	 }

	 public String renewLibraryBookToStudent(String strBookReferenceNumber,String strRenewalDate)
	 {
		 String result = "false";
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result =  objManage.renewLibraryBookToStudent(strBookReferenceNumber,strRenewalDate);
		 
		 return result;
	 }
	 
	 public String returnLibraryBookToLibrary(String strBookReferenceNumber)
	 {
		 String result = "false";
		 app.library.ManageLibrary objManage = new ManageLibrary();
		 result =  objManage.returnLibraryBookToLibrary(strBookReferenceNumber);
		 
		 return result;
	 }
	 
	 public ArrayList<String> getLibraryBooksRelatedData()
		{
			ArrayList<String> result = new ArrayList<String>();
			app.library.ManageLibrary objManage = new ManageLibrary();
			result = objManage.getLibraryBooksRelatedData();
			return result;
		}


}