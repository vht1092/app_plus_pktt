package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DataSourceIntercetor extends HandlerInterceptorAdapter {

	// Request:

	// /publisher/list
	// /advertiser/list
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String contextPath = request.getServletContext().getContextPath();

		// /SpringMVCMultiDS/publisher
		String prefixPublisher = contextPath + "/AtmManagement1";

		// /SpringMVCMultiDS/advertiser
		String prefixAdvertiser = contextPath + "/AtmManagement2";

		// /SpringMVCMultiDS/publisher/dashboard
		// /SpringMVCMultiDS/advertiser/dashboard

		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);

		if (uri.startsWith(prefixPublisher)) {
			request.setAttribute("keyDS", "DW_DS");
		}

		else if (uri.startsWith(prefixAdvertiser)) {
			request.setAttribute("keyDS", "IM_DS");
		}

		return true;
	}

}
