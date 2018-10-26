package com.wingify.news.utilities;

import com.wingify.news.input.Input;

public class InputandTimestamp {
	
	Input input;
	long timestamp;
	public InputandTimestamp() {
		
	}
	public InputandTimestamp(Input input, long timestamp) {
		super();
		this.input = input;
		this.timestamp = timestamp;
	}
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
