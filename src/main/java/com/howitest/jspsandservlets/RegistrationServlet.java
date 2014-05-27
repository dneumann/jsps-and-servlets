package com.howitest.jspsandservlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// for unit tests
	protected Registrator getRegistrator(HttpServletRequest request) {
		return new Registrator();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registrator registrator = getRegistrator(request);
		Parameters params = new Parameters();
		params.username = request.getParameter("username");
		params.password = request.getParameter("password");
		params.gender = request.getParameter("gender");
		
		String validationMessage = registrator.validateData(params);
		if ("OK".equals(validationMessage)) {
			registrator.registerUser(params);
			goToView("success.jsp", request, response);
		} else {
			request.setAttribute("validationMessage", validationMessage);
			goToView("invalid-parameters.jsp", request, response);
		}
	}

	protected void goToView(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}

}
