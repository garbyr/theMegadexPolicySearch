package com.megadex;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ResponseMessage {
	private String message;
	
	public ResponseMessage(String m){
		this.message = m;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
