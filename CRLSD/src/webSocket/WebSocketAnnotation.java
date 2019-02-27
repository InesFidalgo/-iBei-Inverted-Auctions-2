package webSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.server.ServerEndpoint;

import src.Login.LoginAction;

import javax.websocket.OnOpen;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.Session;



@ServerEndpoint(value = "/ws", configurator = webSocketconfig.class)
public class WebSocketAnnotation {
    private Session wsSession;
    private HttpSession httpSession;
    private static final AtomicInteger sequence = new AtomicInteger(1);
    public String username;
    public String []notificacoes;
    private ArrayList <String> usernames = new ArrayList<>();
    public static final Set<WebSocketAnnotation> users = new CopyOnWriteArraySet<>();
    
    public WebSocketAnnotation() {
    	
    }
    @OnOpen
    public void open(Session session, EndpointConfig config) throws IOException, InterruptedException {
    		
    	  this.httpSession = (HttpSession) config.getUserProperties()
                  .get(HttpSession.class.getName());
    	  this.wsSession = session;
    	this.username = (String)this.httpSession.getAttribute("login");
    	this.notificacoes = (String[])this.httpSession.getAttribute("notificacoes");
    	users.add(this);
    	for(WebSocketAnnotation s: users){
    		usernames.add(s.username);
    	}
    	System.out.println(this.username);
    }

   //@OnOpen
   /* public void start(Session session) {
        //this.wsSession = session;
        String message = "*" + this.username + "* connected";
        sendMessage(message);
        users.add(this);
        //sendMessage("Online Users: "+users.size());
    }*/

    @OnClose
    public void end() {
    	usernames.remove(this.username);
    	users.remove(this);
    	sendMessage("Online Users: "+users.size());
    	// clean up once the WebSocket connection is closed
    }

    @OnMessage
    public void receiveMessage(String message) throws IOException, InterruptedException {
    	if(message.equals("login")){
    		System.out.println(message);
    		//this.username = (String)this.httpSession.getAttribute("login");
    		sendMessage("["+this.username+"]: Fez login");
    			sendOff();
    	}
    	
    }
    public void sendOff() throws IOException, InterruptedException{
    	if (this.notificacoes.length >1){
    		for (int i=1;i<notificacoes.length;i++){
    			this.sendUser(this.username, this.notificacoes[i]);
    		}
    		
    	}
    }
    @OnError
    public void handleError(Throwable t) {
    	t.printStackTrace();
    }

    public void sendMessage(String text) {
    	// uses *this* object's session to call sendText()
    	String onlines = "online users: <p>";
		try{
			System.out.println(users.size());
			for(WebSocketAnnotation s: users){
				if (!s.username.equals(this.username)){
					s.wsSession.getBasicRemote().sendText(text);
				}
				for(int i=0;i<usernames.size();i++){
					onlines += " "+usernames.get(i)+"<p>";
					
				}
				s.wsSession.getBasicRemote().sendText(onlines);
				onlines = "online users: <p>";
				s.wsSession.getBasicRemote().sendText("Online users:"+users.size());
				}
    	} catch (IOException e) {
			// clean up once the WebSocket connection is closed}
		 }
    }
    public static int sendUser (String user, String mensagem) throws IOException, InterruptedException{
    		System.out.println("AQUI user: "+user+" mensagem: "+mensagem);
    		System.out.println("size wbs"+users.size());
    		for(WebSocketAnnotation s: users){
    			System.out.println("o que esta lá "+s.username+" | "+ "o que procurei"+user);
    			if (s.username.equals(user)){
    				System.out.println("entrou crlh");
    				s.wsSession.getBasicRemote().sendText(mensagem);
    				return 1;
    				
    			}
    		}
    		return 0;
    }
}
    
