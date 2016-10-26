package com.antra.vo;


import java.util.List;

public class RestResponse {

	private List<String> messages;
	private List<Result> result;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RestResponse[Messages:" + messages + " Result:" + result + "]";
	}
}
