package connect;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet; 

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.util.Iterator;
import java.util.List;

/**
 * Servlet implementation class UploadFiles
 */
public class UploadForms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadForms() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	    if (isMultipart) {
	        FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);

	    try {
	        List items = upload.parseRequest(request);
	        Iterator iterator = items.iterator();
	        while (iterator.hasNext()) {
	            FileItem item = (FileItem) iterator.next();

	            if (!item.isFormField()) {
	                String fileName = item.getName();
	                
	        		String file_name = request.getParameter("file_name");
	        		file_name = file_name.replaceAll("\\s","");
	        		String redirectpath = request.getParameter("redirectpath");

	        		String root = getServletContext().getRealPath("/");
	                File path = new File(root + "/app/uploaded-forms/");
	                if (!path.exists()) {
	                    boolean status = path.mkdirs();
	                }
                    
	                File uploadedFile = new File(path + "/" + fileName);
	                String extension_of_file = FilenameUtils.getExtension(path + "/" + fileName);
	                File newFileName = new File(path + "/" +file_name+ "." +extension_of_file);
	                item.write(uploadedFile);
	                uploadedFile.renameTo(newFileName);
	                response.sendRedirect(request.getContextPath()+redirectpath);
	            }
	        }
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	    if (isMultipart) {
	        FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);

	    try {
	    	   List items = upload.parseRequest(request);
		        Iterator iterator = items.iterator();
		        while (iterator.hasNext()) {
		            FileItem item = (FileItem) iterator.next();

		            if (!item.isFormField()) {
		                String fileName = item.getName();
		                
		        		String file_name = request.getParameter("file_name");
		        		file_name = file_name.replaceAll("\\s","");
		        		String redirectpath = request.getParameter("redirectpath");

		        		String root = getServletContext().getRealPath("/");
		                File path = new File(root + "/app/uploaded-forms/");
		                if (!path.exists()) {
		                    boolean status = path.mkdirs();
		                }
	                    
		                File uploadedFile = new File(path + "/" + fileName);
		                String extension_of_file = FilenameUtils.getExtension(path + "/" + fileName);
		                File newFileName = new File(path + "/" +file_name+ "." +extension_of_file);
		                item.write(uploadedFile);
		                uploadedFile.renameTo(newFileName);
		                response.sendRedirect(request.getContextPath()+redirectpath);
		            }
		        }
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
		
	}
	

}
