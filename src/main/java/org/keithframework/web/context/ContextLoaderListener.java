package org.keithframework.web.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoaderListener extends ContextLoader implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		initWebApplicationContext(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
