package FacebookAPI;

import java.util.Scanner;





//-------------------------------------------------
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//-------------------------------------------------
import java.io.InputStreamReader;

import FacebookAPI.FacebookApi;
import FacebookAPI.ServiceBuilder;
import FacebookAPI.OAuthRequest;
import FacebookAPI.Response;
import FacebookAPI.Token;
import FacebookAPI.Verb;
import FacebookAPI.Verifier;
import FacebookAPI.OAuthService;


public class FacebookCenas
{
  private static final String NETWORK_NAME = "Facebook";
  private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
  private static final Token EMPTY_TOKEN = null;

  public static void main(String[] args) throws IOException
  {
    // Replace these with your own api key and secret
    String apiKey = "384931601851191";
    String apiSecret = "de7a74a0aae074c6a2400f27e57d77e9";
    
    
    OAuthService service = new ServiceBuilder()
                                  .provider(FacebookApi.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .callback("http://localhost:8080/CRLSD/Face.jsp") // Do not change this.
                                  .scope("publish_actions")
                                  .build();
    Scanner in = new Scanner(System.in);

    System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
    System.out.println();

    // Obtain the Authorization URL
    System.out.println("Fetching the Authorization URL...");
    String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
    System.out.println("BLAH BLAH " + EMPTY_TOKEN);
    URL cenas =new URL(authorizationUrl);
    System.out.println("Got the Authorization URL!");
    System.out.println("Now go and authorize Scribe here:");
    System.out.println(authorizationUrl);
    
    //------------------------------------------------------------------
    

    //------------------------------------------------------------------

    System.out.println("And paste the authorization code here");
    System.out.print(">>");
    
    
    Verifier verifier = new Verifier(in.nextLine());
    System.out.println();
    
    // Trade the Request Token and Verifier for the Access Token
    System.out.println("Trading the Request Token for an Access Token...");
    Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
    System.out.println("BLAH BLAH 2" + EMPTY_TOKEN);
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

    
    System.out.println();
    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
    //return "loginFaceSucess";
    
  }
  
  
  
}
