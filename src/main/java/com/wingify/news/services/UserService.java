package com.wingify.news.services;

import java.util.ArrayList;
import java.util.HashMap;




import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wingify.news.input.Article;
import com.wingify.news.input.Input;
import com.wingify.news.input.PostObject;
import com.wingify.news.output.Output;
import com.wingify.news.output.OutputArticle;
import com.wingify.news.utilities.InputandTimestamp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class UserService {

	HashMap<String, InputandTimestamp> isPresent = new HashMap<>();

	public String buildUrl(String country, String category) {
		
		
		String baseURL = "https://newsapi.org/v2/top-headlines?apiKey=eadb6da4bb5847a8b5f5b8a633e53ab9";
        
		int index = 0;
		for(int i=0;i<baseURL.length();i++)
		{
			if(baseURL.charAt(i)=='?')
			{
				index = i;
				break;
			}
		}
		String leftpart  = baseURL.substring(0,index+1);
		String rightpart = baseURL.substring(index+1);
		
		if(country!=null && category!=null)
		{
			return (leftpart + "category="+category+"&"+"country="+country+"&"+rightpart);
		}
		else if(country==null && category!=null)
		{
			return (leftpart + "category="+category+"&"+rightpart);
		}
		else if(country!=null && category==null)
		{
			return (leftpart + "country="+country+"&"+rightpart);
		}
		else
		{
			return (leftpart + "category="+category+"&"+"country="+country+"&"+rightpart);
		}
		
		
	}
	
	public  String getJsonResponse(String url) throws Exception {
        OkHttpClient okhttpclient = new OkHttpClient();
        Request.Builder requestbuilder = new Request.Builder();
        requestbuilder.url(url);
        Request request = requestbuilder.build();
        
        try {
            Response response = okhttpclient.newCall(request).execute();
            String jsonResponse = response.body().string();
            return jsonResponse;
       
        } catch (Exception e) {
            e.printStackTrace();
            return "Connection could not be established!"+e;
        }
    }
    
	public Input getInputObject(PostObject postobject) throws Exception {
		
		String country = postobject.getCountry();
		String category  = postobject.getCategory();
		String key = country + category;
		java.util.Date date =new java.util.Date();
		long presentTime = date.getTime();
		if(isPresent.containsKey(key)) {
			long oldTime = isPresent.get(key).getTimestamp();
			if(presentTime-oldTime<600000)
			{
				return isPresent.get(key).getInput();
			}
			else
			{
				String url  = buildUrl(country, category);
				if(url!=null)
				{
					String jsonResponse = getJsonResponse(url);
					Gson g = new Gson();
					Input inputObject = g.fromJson(jsonResponse, Input.class);
					isPresent.put(key,new InputandTimestamp(inputObject,presentTime));
					return inputObject;
				}
				else
				{
					
					String jsonResponse = getJsonResponse(url);
					Gson g = new Gson();
					Input inputObject = g.fromJson(jsonResponse, Input.class);
					isPresent.put(key,new InputandTimestamp(inputObject,presentTime));
					return inputObject;
				}
				
			}
			
		}
		else
		{
			String url  = buildUrl(country, category);
			if(url!=null)
			{
				String jsonResponse = getJsonResponse(url);
				Gson g = new Gson();
				Input inputObject = g.fromJson(jsonResponse, Input.class);
				isPresent.put(key,new InputandTimestamp(inputObject,presentTime));
				return inputObject;
			}
			else
			{
				String jsonResponse = getJsonResponse(url);
				Gson g = new Gson();
				Input inputObject = g.fromJson(jsonResponse, Input.class);
				isPresent.put(key,new InputandTimestamp(inputObject,presentTime));
				return inputObject;
			}
			
		}
		
		
	}

	public Output getOutput(Input input,PostObject postobject) {
		
		String country = postobject.getCountry();
		String category  = postobject.getCategory();
		String keyword = postobject.getKeyword();
		Output output = new Output();
		output.setCountry(country);
		output.setKeyword(keyword);
		output.setCategory(category);
		
		ArrayList<OutputArticle> outputArticles = new ArrayList<>();
		ArrayList<Article> articles = input.getArticles();
		
		if(keyword!=null)
		{
			for(int i=0;i<articles.size();i++)
			{
				Article article = articles.get(i);
				if(isKeywordPresent(article,keyword))
				{
					OutputArticle outputarticle = new OutputArticle();
					outputarticle.setDescription(article.getDescription());
					outputarticle.setTitle(article.getTitle());
					outputarticle.setUrl(article.getUrl());
					outputArticles.add(outputarticle);
				}
				
				
			}
		}
		else
		{
			for(int i=0;i<articles.size();i++)
			{
				Article article = articles.get(i);
				OutputArticle outputarticle = new OutputArticle();
				outputarticle.setDescription(article.getDescription());
				outputarticle.setTitle(article.getTitle());
				outputarticle.setUrl(article.getUrl());
				outputArticles.add(outputarticle);
			}
		}
		output.setArticles(outputArticles);
		return output;	
		
		
	}

	private boolean isKeywordPresent(Article article, String keyword) {
		
		String title = article.getTitle();
		String content = article.getContent();
		String description = article.getDescription();
		
		if(title!=null && title.contains(keyword))
		{
			return true;
		}
		
		if(content!=null && content.contains(keyword))
		{
			return true;
		}
		if(description!=null && description.contains(keyword))
		{
			return true;
		}
		return false;
	}


}
