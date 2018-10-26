# news-api

# File System

![filesystem](https://user-images.githubusercontent.com/20643833/47582285-93dbfd80-d971-11e8-97e5-621cd3c1e034.png)

Classes and uses of it :- 

1. Application.java - It is the class with main method which runs our application by making the servlet container and starting the tomcat server.
2. Article.java - It is the class maps to JSONArray (Article) which we will get from the newsAPI.
3. Input.java - It is the class maps to JSONObject which we will get from the newsAPI.
4. PostObject.java - It is the class which maps the JSONObject which we will be getting from the user from post request.
5. Output.java - Output class maps to the JSONOBject which server has to send to the user as a response.
6. OutputArticle.java - Output article maps to the JSONArray(Article) which server will send to user(Client side) as a response.
7. InputandTimeStamp.java - This is the class which contains the input class object and the timestamp in milliseconds.It is the utility class for the hashmap which i used to maintain the track of API calls happened in every ten minutes.
8. Userservice.java - User service class is giving service to the controller.There are many functions in there which is properly commented of why they are used.
9. UserController - User controller is the restcontroller which is mapping the request from the user to the response given by the server.

# Working

1. User clicks the 'get news' button by selecting the country and category and writing the keyword(optional).
2. Request hits the controller and corresponding function (postNews) is executed.In that,input class object is extracted by calling getInputObject() in which we pass the postobject class object.
     - getInputObject() - In this, the country and category is extracted from the postobject and key(country + category) is            made for the hashmap,then we checked if the hashmap already contains the value corresponding to the key and if it is            then the API hit with these parameters has already been happen in less than ten minutes,so it returns the object from          the hashmap only, and if no then it builds the url by calling buildURL method and send the request to the newsapi and 
       fetch the required news.
3. Then the getOutput() method is called which return the output class object.
     - getOutput() - In this,first we check if the keyword is null and if it is then we dont filter the articles and if it is          not then we see if the any article contains that keyword in its title,description or content and if that comes out to be        true then we finally add it to the arraylist of the article and returns the output.
# Output Screenshot

![output](https://user-images.githubusercontent.com/20643833/47583849-4746f100-d976-11e8-9c40-2b4969d27c6c.png)

![output2](https://user-images.githubusercontent.com/20643833/47584003-99881200-d976-11e8-8d55-349aa72bea83.png)

TO ACCESS THE SIMPLE APPLICATION
https://filterednews.herokuapp.com/
