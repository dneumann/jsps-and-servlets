package com.howitest.jspsandservlets;

public class Registrator {

	public String validateData(Parameters params) {
		String validationMessage = "";
		if (isEmpty(params.username)) {
			validationMessage += "No username. ";
		}
		if (isEmpty(params.password)) {
			validationMessage += "No password. ";
		}
		return validationMessage;
	}
	
	private boolean isEmpty(String string) {
		return string == null || string.isEmpty();
	}
	
	public void registerUser(Parameters params) {
		// not yet implemented
	}

}
