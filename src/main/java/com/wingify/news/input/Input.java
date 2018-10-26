package com.wingify.news.input;

import java.util.ArrayList;

public class Input {
	
	private String status;
	private String totalResults;
	
	private ArrayList<Article> articles;
	
	public Input() {
		
	}

	public Input(String status, String totalResults, ArrayList<Article> articles) {
		super();
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	

}
