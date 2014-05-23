package com.howitest.jspsandservlets.testutil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParameterPrintingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Map<String, String[]> allParams = request.getParameterMap();
		for (Map.Entry<String, String[]> parameter : allParams.entrySet()) {
			out.println(parameter.getKey() + ": " + Arrays.toString(parameter.getValue()));
		}
	}

}
