package com.wingify.news.input;

public class PostObject {
	
	private String country;
	private String category;
	private String keyword;
	
	public PostObject() {
		
	}
	
	public PostObject(String country, String category, String keyword) {
		super();
		this.country = country;
		this.category = category;
		this.keyword = keyword;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}
