package connect;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UploadFiles
 */
public class UploadFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFiles() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String folder = request.getParameter("folder");
		String redirectpath = request.getParameter("redirectpath");
		String fileName = request.getParameter("file_name");
		fileName = fileName.replaceAll("\\s","");
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath("/");
		contextPath = contextPath + "\\app\\files\\" + folder;
		File file = new File(contextPath);
		if (!file.exists()) {
			file.mkdir();
		}
		
		MultipartRequest m=new MultipartRequest(request, contextPath, 52428800);
		File ImageScannedCopyOldName[] = file.listFiles();
        
	    for (int i = 0; i < ImageScannedCopyOldName.length; i++) {
	    	String extension_of_file = FilenameUtils.getExtension(contextPath+ImageScannedCopyOldName[i]);
	    	File ImageScannedCopyNewName = new File(contextPath+"\\"+fileName+"."+extension_of_file);
	    	FileUtils.copyFile(ImageScannedCopyOldName[i], ImageScannedCopyNewName);   
	    	ImageScannedCopyOldName[i].delete();
	    }
		response.sendRedirect(request.getContextPath()+redirectpath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String folder = request.getParameter("folder");
		String redirectpath = request.getParameter("redirectpath");
		String fileName = request.getParameter("file_name");
		fileName = fileName.replaceAll("\\s","");
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath("/");
		contextPath = contextPath + "\\app\\files\\" + folder;
		File file = new File(contextPath);
		if (!file.exists()) {
			file.mkdir();
		}
		MultipartRequest m = new MultipartRequest(request, contextPath,52428800);
		File ImageScannedCopyOldName[] = file.listFiles();
		    for (int i = 0; i < ImageScannedCopyOldName.length; i++) {
		    	String extension_of_file = FilenameUtils.getExtension(contextPath+ImageScannedCopyOldName[i]);
		    	File ImageScannedCopyNewName = new File(contextPath+"\\"+fileName+"."+extension_of_file);
		    	FileUtils.copyFile(ImageScannedCopyOldName[i], ImageScannedCopyNewName);   
		    	ImageScannedCopyOldName[i].delete();
		    }
		    
		response.sendRedirect(request.getContextPath()+redirectpath);
	}

}
