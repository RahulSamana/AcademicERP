package webapp.exchange;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.nio.file.Files;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

public class Notes {
	 ArrayList<String>  fileNames = new ArrayList<String>();
	public ArrayList<String> getPreviouslyUploadedNotes(String strDepartment, String strUnique_ID)
	{
	ArrayList<String> result = new ArrayList<String>();
	String appDirectory = System.getProperty("catalina.base"); 	
	//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-notes/"+strDepartment+"/"+strUnique_ID+"";
	appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
	File check_if_exists = new File(appDirectory);
	if(check_if_exists.exists())
	{
		File[] files = new File(appDirectory).listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
	    
		for (File file : files) {
		    if (file.isFile()) {
		    	result.add(file.getName());
		    }
		}
	}
	else
	{
		result.add("empty-list");
	}
	return result;
	}
	
	public String deleteExistingUpload(String strDepartment, String strUnique_ID, String strFileName)
	{
		String result = "false";
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-notes/"+strDepartment+"/"+strUnique_ID+"";
		appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
		boolean boolean_result = FileUtils.deleteQuietly(new File(appDirectory));
		if(boolean_result== true)
		{
			result="true";
		}
		return result;
	}
	public ArrayList<String> setDirectory(String strdirectoryName) 
	{
			ArrayList<String> NamesofFiles = new ArrayList<String>();
			String appDirectory = System.getProperty("catalina.base"); 	
			//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-notes/"+strdirectoryName+"";
			appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
			File file = new File(appDirectory);
			displayDirectoryContents(file);
		    NamesofFiles = fileNames;
		    return NamesofFiles;
	
    }
	public  void displayDirectoryContents(File dir)  {
		try {
			
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					displayDirectoryContents(file);
				} else {					
					String parentFolder= getParentName(file);
					fileNames.add(parentFolder+"/"+file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public static String getParentName(File file) {
	    if(file == null || file.isDirectory()) {
	            return null;
	    }
	    String parent = file.getParent();
	    parent = parent.substring(parent.lastIndexOf("\\") + 1, parent.length());
	    return parent;      
	}
	
	

}