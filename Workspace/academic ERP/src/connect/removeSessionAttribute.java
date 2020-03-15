package connect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitPage
 */
public class removeSessionAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public removeSessionAttribute() {
		super();
		// TODO Auto-generated constructor stub
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
						String attributeName = request.getParameter(Messages.getString("connect.name")); //$NON-NLS-1$
						session.removeAttribute(attributeName);
						response.getWriter().write(Messages.getString("connect.true")); //$NON-NLS-1$
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
						String attributeName = request.getParameter(Messages.getString("connect.name")); //$NON-NLS-1$
						session.removeAttribute(attributeName);
						response.getWriter().write(Messages.getString("connect.true")); //$NON-NLS-1$
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
