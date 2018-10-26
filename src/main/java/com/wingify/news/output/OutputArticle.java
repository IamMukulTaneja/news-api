package com.wingify.news.output;


public class OutputArticle {
	
	private String title;
	private String description;
	private String url;
	
	public OutputArticle() {
		
	}
	
	public OutputArticle(String title, String description, String url) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
