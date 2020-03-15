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
public class logoutSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logoutSession() {
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
					boolean result = false;
					try {
						session.removeAttribute(Messages.getString("connect.user")); //$NON-NLS-1$
						response.setHeader("Cache-control", "no-store"); //$NON-NLS-1$ //$NON-NLS-2$
						response.setHeader("Pragma", "no-cache"); //$NON-NLS-1$ //$NON-NLS-2$
						response.setDateHeader("Expire", 0); //$NON-NLS-1$
						session.invalidate();
						result = true;
						response.getWriter().write(Boolean.toString(result));
					} catch (Exception e) {
						response.getWriter().write(Boolean.toString(result));
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
					boolean result = false;
					try {
						session.removeAttribute("User"); //$NON-NLS-1$
						response.setHeader("Cache-control", "no-store"); //$NON-NLS-1$ //$NON-NLS-2$
						response.setHeader("Pragma", "no-cache"); //$NON-NLS-1$ //$NON-NLS-2$
						response.setDateHeader("Expire", 0); //$NON-NLS-1$
						session.invalidate();
						result = true;
						response.getWriter().write(Boolean.toString(result));
					} catch (Exception e) {
						response.getWriter().write(Boolean.toString(result));
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
