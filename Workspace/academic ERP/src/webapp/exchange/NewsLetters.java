package webapp.exchange;


import java.util.ArrayList;
import java.util.List;
import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

public class NewsLetters {

	public ArrayList<String> getPreviouslyUploadedNewsLetters()
	{
	ArrayList<String> result = new ArrayList<String>();
	String appDirectory = System.getProperty("catalina.base"); 	
	//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-news-letters";
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
	
	public String deleteExistingUpload(String str_file_name)
	{
		String result = "false";
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-news-letters/"+str_file_name+"";
		appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
		boolean boolean_result = FileUtils.deleteQuietly(new File(appDirectory));
		if(boolean_result== true)
		{
			result="true";
		}
		return result;
	}
	public String getNewsLettersRelatedData()
	{
		int result = 0;
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-news-letters";
		appDirectory = "C:/Users/sujithkumar/Desktop/Academic ERP/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/uploaded-news-letters";
		File check_if_exists = new File(appDirectory);
		if(check_if_exists.exists())
		{
			File[] files = new File(appDirectory).listFiles();
			//If this pathname does not denote a directory, then listFiles() returns null. 
			 result = files.length;
		}
		else
		{
			result = 0;
		}
		return Integer.toString(result);
		}
	
}


