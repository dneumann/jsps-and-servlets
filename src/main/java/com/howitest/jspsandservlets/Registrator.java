package com.howitest.jspsandservlets;

public class Registrator {

	public String validateData(Parameters params) {
		String errorMessage = null;
		if (isEmpty(params.username)) {
			errorMessage += "No username. ";
		}
		if (isEmpty(params.password)) {
			errorMessage += "No password. ";
		}
		if (isEmpty(errorMessage)) {
			return "OK";
		} else {
			return errorMessage;
		}
	}
	
	private boolean isEmpty(String string) {
		return string == null || string.isEmpty();
	}
	
	public void registerUser(Parameters params) {
		// not yet implemented
	}

}
