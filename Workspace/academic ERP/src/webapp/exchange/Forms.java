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

public class Forms {

	public ArrayList<String> getPreviouslyUploadedForms()
	{
	ArrayList<String> result = new ArrayList<String>();
	String appDirectory = System.getProperty("catalina.base"); 	
	//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-forms";
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
	
	public String deleteExistingUpload(String strFileName)
	{
		String result = "false";
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-forms/"+strFileName+"";
		appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
		boolean boolean_result = FileUtils.deleteQuietly(new File(appDirectory));
		if(boolean_result== true)
		{
			result="true";
		}
		return result;
	}
	public String getFormsRelatedData()
	{
		int result = 0;
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/uploaded-forms";
		appDirectory = "C:/Users/sujithkumar/Desktop/Academic ERP/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/uploaded-forms";
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


