package com.howitest.jspsandservlets.testutil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

import com.howitest.jspsandservlets.Parameters;
import com.howitest.jspsandservlets.RegistrationServlet;
import com.howitest.jspsandservlets.Registrator;


public class RegistrationServletChild extends RegistrationServlet {

	private static final long serialVersionUID = 1L;
	
	private ThreadLocal<Registrator> registratorLocal = new ThreadLocal<Registrator>();

	@Override
	protected Registrator getRegistrator(HttpServletRequest request) {
		Registrator registrator = mock(Registrator.class);
		String fakeValidationMessage = request.getParameter("fakeValidationMessage");
		when(registrator.validateData(any(Parameters.class))).thenReturn(fakeValidationMessage);
		registratorLocal.set(registrator);
		return registrator;
	}
	
	@Override
	protected void goToView(String viewName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fakeValidationMessage = request.getParameter("fakeValidationMessage");
		Registrator registrator = registratorLocal.get();
		if ("".equals(fakeValidationMessage)) {
			verify(registrator).registerUser(any(Parameters.class));
		}
		PrintWriter out = response.getWriter();
		out.print("Forwarded to view: " + viewName);
	}
}
