package com.megadex;

import java.util.List;

public class MegadexErrorMessageWrapper implements IMegadexResponseWrapper {

	private List<String> messages;

	public MegadexErrorMessageWrapper(List<String> e){
		this.messages = e;
	}
	
	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
}
