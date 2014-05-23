package com.howitest.jspsandservlets;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;


public class IndexJspTestPart {
	
	private static int jettyPort = TestSuiteForJspsAndServlets.jettyPort;
	private HtmlForm form;
	
	@Before
	public void beforeEachTest() throws Exception {
		WebClient webClient = new WebClient();
		HtmlPage jsp = webClient.getPage("http://localhost:" + jettyPort + "/index.jsp");
		form = jsp.getFormByName("commitData");
	}

	@Test
	public void shouldContainAllInputFields() {
		form.getInputByName("username");
		form.getInputByName("password");
		assertThat("No gender radio buttons found", form.getRadioButtonsByName("gender"), is(not(empty())));
		form.getInputByName("submit");
	}
	
	@Test
	public void submittingTheFormShouldPostAllParameters() throws Exception {
		form.getInputByName("username").setValueAttribute("testuser");
		form.getInputByName("password").setValueAttribute("testpassword");
		form.getRadioButtonsByName("gender").get(1).click();
		
		HtmlSubmitInput button = form.getInputByName("submit");
		TextPage fakeServlet = button.click();
		String textFromFakeServlet = fakeServlet.getContent();
		
		assertThat(textFromFakeServlet, containsString("testuser"));
		assertThat(textFromFakeServlet, containsString("testpassword"));
		assertThat(textFromFakeServlet, containsString("female"));
	}
	
}
