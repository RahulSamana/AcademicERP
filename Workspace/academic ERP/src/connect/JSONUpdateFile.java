package connect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class SubmitPage
 */
public class JSONUpdateFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONUpdateFile() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json"); //$NON-NLS-1$
		response.setHeader("Cache-Control", "no-cache"); //$NON-NLS-1$ //$NON-NLS-2$
		HttpSession session = request.getSession();
		if (session == null) {
			response.getWriter().write(
					Messages.getString("connect.SessionExpiredException")); //$NON-NLS-1$
		} else {
			if (request.getHeader("X-Requested-With") != null) { //$NON-NLS-1$
				if (request.getHeader("X-Requested-With").equalsIgnoreCase( //$NON-NLS-1$
						"XMLHttpRequest")) { //$NON-NLS-1$
					try {
						String filePath = request.getParameter("file"); //$NON-NLS-1$
						ServletContext servletContext = getServletContext();
						String contextPath = servletContext.getRealPath("/");
						filePath = contextPath + "\\app\\json\\" + filePath;
						String returnString = null;
						JsonObject jsonObject = new JsonObject();

						try {
							
							JsonParser parser = new JsonParser();
							JsonElement jsonElement;

							jsonElement = parser.parse(new FileReader(filePath));
							

							jsonObject = jsonElement.getAsJsonObject();
							
							String counter = request.getParameter("count");
							String key = request.getParameter("key");
							String value = request.getParameter("value");
							int count = 0;
							try{
								count = Integer.parseInt(counter);
							}catch(Exception e){
								response.getWriter().write(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
							}
							JsonArray array = jsonObject.getAsJsonArray();
							try{
								array.get(count).getAsJsonObject().addProperty(key, value);
							}
							catch(IndexOutOfBoundsException e){
								JsonObject object = new JsonObject();
								object.addProperty(key, value);
								array.add(object);
							}
							
							if(jsonObject != null){
								returnString = jsonObject.toString();
							}
							
							File file = new File(filePath);
							if (!file.exists()) {
								file.createNewFile();
							}

							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(returnString);
							bw.close();
							
						} catch (FileNotFoundException e) {
							response.getWriter().write(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
						} catch (IOException ioe) {
							response.getWriter().write(Messages.getString("connect.Exception") + ioe); //$NON-NLS-1$
						}

						if (returnString == null) {
							response.getWriter().write(Messages.getString("connect.null")); //$NON-NLS-1$
						} else {
							response.getWriter().write("true");
						}
					} catch (Exception e) {
						response.getWriter().write(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
					}
				} else {
					response.getWriter().write(
							Messages.getString("connect.SessionExpiredException")); //$NON-NLS-1$
				}
			} else {
				response.getWriter().write(
						Messages.getString("connect.SessionExpiredException")); //$NON-NLS-1$
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
		response.setContentType("application/json"); //$NON-NLS-1$
		response.setHeader("Cache-Control", "no-cache"); //$NON-NLS-1$ //$NON-NLS-2$
		HttpSession session = request.getSession();
		if (session == null) {
			response.getWriter().write(
					Messages.getString("connect.SessionExpiredException")); //$NON-NLS-1$
		} else {
			if (request.getHeader("X-Requested-With") != null) { //$NON-NLS-1$
				if (request.getHeader("X-Requested-With").equalsIgnoreCase( //$NON-NLS-1$
						"XMLHttpRequest")) { //$NON-NLS-1$
					try {
						String filePath = request.getParameter("file"); //$NON-NLS-1$
						ServletContext servletContext = getServletContext();
						String contextPath = servletContext.getRealPath("/");
						filePath = contextPath + "\\app\\json\\" + filePath;
						String returnString = null;
						JsonObject jsonObject = new JsonObject();

						try {
							
							JsonParser parser = new JsonParser();
							JsonElement jsonElement;

							jsonElement = parser.parse(new FileReader(filePath));
							

							jsonObject = jsonElement.getAsJsonObject();
							
							String counter = request.getParameter("count");
							String key = request.getParameter("key");
							String value = request.getParameter("value");
							int count = 0;
							try{
								count = Integer.parseInt(counter);
							}catch(Exception e){
								response.getWriter().write(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
							}
							
							JsonArray array = jsonObject.get("items").getAsJsonArray();
							try{
								array.get(count).getAsJsonObject().addProperty(key, value);
							}
							catch(IndexOutOfBoundsException e){
								JsonObject object = new JsonObject();
								object.addProperty(key, value);
								array.add(object);
							}
							if(jsonObject != null){
								returnString = jsonObject.toString();
							}
							
							File file = new File(filePath);
							if (!file.exists()) {
								file.createNewFile();
							}

							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(returnString);
							bw.close();
							
						} catch (FileNotFoundException e) {
							response.getWriter().write(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
						} catch (IOException ioe) {
							response.getWriter().write(Messages.getString("connect.Exception") + ioe); //$NON-NLS-1$
						}

						if (returnString == null) {
							response.getWriter().write(Messages.getString("connect.null")); //$NON-NLS-1$
						} else {
							response.getWriter().write("true");
						}
					} catch (Exception e) {
						response.getWriter().write(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
					}
				} else {
					response.getWriter().write(
							Messages.getString("connect.SessionExpiredException")); //$NON-NLS-1$
				}
			} else {
				response.getWriter().write(
						Messages.getString("connect.SessionExpiredException")); //$NON-NLS-1$
			}
		}
	}
}
