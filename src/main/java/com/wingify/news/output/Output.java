package com.wingify.news.output;

import java.util.ArrayList;

public class Output {
	
	private String country;
	private String category;
	private String keyword;
	
	private ArrayList<OutputArticle> articles;

	public Output() {
		
	}
	
	public Output(String country, String category, String keyword, ArrayList<OutputArticle> articles) {
		super();
		this.country = country;
		this.category = category;
		this.keyword = keyword;
		this.articles = articles;
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

	public ArrayList<OutputArticle> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<OutputArticle> articles) {
		this.articles = articles;
	}
	
	

}
