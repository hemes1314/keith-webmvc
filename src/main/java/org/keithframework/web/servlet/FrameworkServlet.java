package org.keithframework.web.servlet;

import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FrameworkServlet extends HttpServletBean {

	private static final long serialVersionUID = 8510904131557094325L;

	private WebApplicationContext webApplicationContext;
	
	protected WebApplicationContext initWebApplicationContext() {
		WebApplicationContext rootContext =
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		WebApplicationContext wac = null;

		if (this.webApplicationContext != null) {
			// A context instance was injected at construction time -> use it
			wac = this.webApplicationContext;
			if (wac instanceof ConfigurableWebApplicationContext) {
				ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) wac;
				if (!cwac.isActive()) {
					// 如果没有初始化则启动Ioc容器初始化
					if (cwac.getParent() == null) {
						cwac.setParent(rootContext);
					}
					configureAndRefreshWebApplicationContext(cwac);
				}
			}
		}
//		if (wac == null) {
//			// No context instance was injected at construction time -> see if one
//			// has been registered in the servlet context. If one exists, it is assumed
//			// that the parent context (if any) has already been set and that the
//			// user has performed any initialization such as setting the context id
//			wac = findWebApplicationContext();
//		}
//		if (wac == null) {
//			// No context instance is defined for this servlet -> create a local one
//	}
//		wac = createWebApplicationContext(rootContext);

		// 初始化SpringMVC
		if (!this.refreshEventReceived) {
			onRefresh(wac);
		}
//
//		if (this.publishContext) {
//			// Publish the context as a servlet context attribute.
//			String attrName = getServletContextAttributeName();
//			getServletContext().setAttribute(attrName, wac);
//			if (this.logger.isDebugEnabled()) {
//				this.logger.debug("Published WebApplicationContext of servlet '" + getServletName() +
//						"' as ServletContext attribute with name [" + attrName + "]");
//			}
//		}

		return wac;
	}
}
