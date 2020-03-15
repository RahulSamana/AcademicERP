package connect;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class StaticResourceFilter
 */
public class StaticResourceFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public StaticResourceFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		String path = req.getRequestURI().substring(
				req.getContextPath().length());

		if (path.equals(Messages.getString("connect.Filter.root"))) { //$NON-NLS-1$
			((HttpServletResponse) response).sendRedirect(Messages.getString("connect.Filter.login")); //$NON-NLS-1$
			return;
		}
		if (path.contains(Messages.getString("connect.Filter.images")) || path.contains(Messages.getString("connect.Filter.css")) //$NON-NLS-1$ //$NON-NLS-2$
				|| path.contains(Messages.getString("connect.Filter.js")) || path.contains(Messages.getString("connect.Filter.json")) || path.contains(Messages.getString("connect.Filter.fonts")) //$NON-NLS-1$ //$NON-NLS-2$
				|| path.contains(Messages.getString("connect.Filter.js/")) || path.contains(Messages.getString("connect.Filter.json/")) || path.contains(Messages.getString("connect.Filter.css/")) //$NON-NLS-1$ //$NON-NLS-2$
				|| path.contains(Messages.getString("connect.Filter.images/")) || path.contains(Messages.getString("connect.Filter.fonts/"))
				|| path.contains(Messages.getString("connect.Filter.uploaded-notes/")) || path.contains(Messages.getString("connect.Filter.uploaded-notes/"))
				|| path.contains(Messages.getString("connect.Filter.uploaded-news-letters/")) || path.contains(Messages.getString("connect.Filter.uploaded-news-letters/"))
				|| path.contains(Messages.getString("connect.Filter.uploaded-forms/")) || path.contains(Messages.getString("connect.Filter.uploaded-forms/"))
				|| path.contains(Messages.getString("connect.Filter.files")) || path.contains(Messages.getString("connect.Filter.files/"))) { //$NON-NLS-1$ //$NON-NLS-2$
			      
			if (path.startsWith(Messages.getString("connect.Filter.images")) || path.startsWith(Messages.getString("connect.Filter.css")) //$NON-NLS-1$ //$NON-NLS-2$
					|| path.startsWith(Messages.getString("connect.Filter.js")) //$NON-NLS-1$
					|| path.startsWith(Messages.getString("connect.Filter.fonts"))
					|| path.startsWith(Messages.getString("connect.Filter.json"))
					|| path.startsWith(Messages.getString("connect.Filter.uploaded-notes"))
					|| path.startsWith(Messages.getString("connect.Filter.uploaded-news-letters"))
					|| path.startsWith(Messages.getString("connect.Filter.uploaded-forms"))
					|| path.startsWith(Messages.getString("connect.Filter.files"))) { //$NON-NLS-1$
				chain.doFilter(request, response);
			} else {
				if (path.contains(Messages.getString("connect.Filter.js/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.js/")), //$NON-NLS-1$
							path.length());
				} else if (path.contains(Messages.getString("connect.Filter.css/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.css/")), //$NON-NLS-1$
							path.length());
				} else if (path.contains(Messages.getString("connect.Filter.images/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.images/")), //$NON-NLS-1$
							path.length());
				} else if (path.contains(Messages.getString("connect.Filter.fonts/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.fonts/")), //$NON-NLS-1$
							path.length());
				} else if (path.contains(Messages.getString("connect.Filter.uploaded-notes/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.uploaded-notes/")), //$NON-NLS-1$
							path.length());
				} else if (path.contains(Messages.getString("connect.Filter.uploaded-news-letters/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.uploaded-news-letters/")), //$NON-NLS-1$
							path.length());
				} else if (path.contains(Messages.getString("connect.Filter.uploaded-forms/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.uploaded-forms/")), //$NON-NLS-1$
							path.length());
				}else if (path.contains(Messages.getString("connect.Filter.files/"))) { //$NON-NLS-1$
						path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.files/")), //$NON-NLS-1$
								path.length());
				}
				if (path.contains(Messages.getString("connect.Filter.json/"))) { //$NON-NLS-1$
					path = path.substring(path.lastIndexOf(Messages.getString("connect.Filter.json/")), //$NON-NLS-1$
							path.length());
				}

				request.getRequestDispatcher(Messages.getString("connect.Filter.app") + path).forward(request, //$NON-NLS-1$
						response);
			}
		} else {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
