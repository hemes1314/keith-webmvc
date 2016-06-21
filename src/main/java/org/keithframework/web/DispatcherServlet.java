package org.keithframework.web;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.keithframework.web.servlet.FrameworkServlet;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends FrameworkServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
