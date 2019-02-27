package FacebookLoginInside;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import FacebookAPI.FacebookApi;
import FacebookAPI.OAuthRequest;
import FacebookAPI.OAuthService;
import FacebookAPI.Response;
import FacebookAPI.ServiceBuilder;
import FacebookAPI.Token;
import FacebookAPI.Verb;
import FacebookAPI.Verifier;

import rmi.Leilao;

//---------------------------------



//FACEBOOK!!!!!!!!!!!!!!!!
public class LogInside extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	LogInside novo = null;
	private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	static final Token EMPTY_TOKEN = null;
	String authorizationUrl= null;
  	OAuthService service = null;
  	boolean flag = false;
  	String code = null;
  	
  	public String getCode()
  	{
  		return code;
  	}
  	
  	public void setCode(String code)
  	{
  		this.code = code;
  	}  	
  	
  	public String getAuthorizationUrl()
  	{
  		return authorizationUrl;
  	}

	public void setService()
	{
		String apiKey = "384931601851191";
	    String apiSecret = "de7a74a0aae074c6a2400f27e57d77e9";
	    	    
	    this.service = new ServiceBuilder()
	                                  .provider(FacebookApi.class)
	                                  .apiKey(apiKey)
	                                  .apiSecret(apiSecret)
	                                  .callback("http://localhost:8080/CRLSD/FacebookLoginInside.action") 
	                                  // Do not change this.
	                                  .scope("publish_actions")
	                                  .build();
	}
	
	
	public String execute() throws URISyntaxException, IOException{
		System.out.println("flag 1: " + flag);
		//if (!flag)
		setService();
		if (code == null)
		{
			this.flag = true;
			System.out.println("flag 2: " + flag);
		    //System.out.println("Fetching the Authorization URL...");
		    authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
		    //System.out.println("Got the Authorization URL!");
		    //System.out.println("Now go and authorize Scribe here:");
		    //System.out.println(authorizationUrl);
		    return "loginFaceSuccess2";
		}
		else
		{
			System.out.println(code);
			Verifier verifier = new Verifier(code.toString());
		    System.out.println();
		    
		    // Trade the Request Token and Verfier for the Access Token
		    System.out.println("Trading the Request Token for an Access Token...");
		    
		    Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
		    System.out.println("Got the Access Token!");
		    System.out.println("(if your curious it looks like this: " + accessToken + " )");
		    System.out.println();

		    // Now let's go and ask for a protected resource!
		    System.out.println("Now we're going to access a protected resource...");
		    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
		    service.signRequest(accessToken, request);
		    Response response = request.send();
		    System.out.println("Got it! Lets see what we found...");
		    System.out.println();
		    System.out.println("cenas"+response.getCode());
		    System.out.println(response.getBody());
		    
		    String[] stuff = response.getBody().replace("\"", "").replace("{", "").replace("}", "").split("[:,]");
		    
		    String save = null;
		    int a = 0;
		    for (String s: stuff)
		    {
		    	a++;
		    	if (s.equals("id"))
		    	{
		    		save= stuff[a];	 	
		    	}
		    	System.out.println("\t"+s);
		    }
		    
		    this.getLoginBean().setFID(save);
		    
		    if (this.getLoginBean().tryLoginInside())
		    {
		    	System.out.println("entrou aqui fb!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+code);
		    	return "tryLoginInsideSuccess";
		    }
		    else{
		    	System.out.println("entrou aqui fb!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+code);
		    	return "tryLoginInsideFail";
		    }
		    
		    /*
			if(this.getCreateLeilaoBean().createLeilao())
			{
				return "createLeilaoSuccess";
			}
			return "createLeilaoError";

		    return "loginFaceFail";*/
		}
	}

	
	public LogInsideBean getLoginBean()
	{
		if(!session.containsKey("loginBeanF"))
		{
			this.setLoginBean(new LogInsideBean());
		}
		return (LogInsideBean) session.get("loginBeanF");
	}

	public void setLoginBean(LogInsideBean loginBean)
	{
		this.session.put("loginBeanF",loginBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
	
}