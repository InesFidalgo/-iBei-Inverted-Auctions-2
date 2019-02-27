package src.Login;

import com.opensymphony.xwork2.ActionSupport;


import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import rmi.Security;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import webSocket.WebSocketAnnotation;

public class LoginAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String login=null, password=null;


	@Override
	public String execute() throws Exception
	{
		WebSocketAnnotation a = new WebSocketAnnotation();
		this.getLoginBean().setLogin(this.login);
		this.getLoginBean().setPassword(this.password);
		if(this.getLoginBean().tryLogin())
		{
			
			session.put("login",this.login);
			session.put("Socket", a);
			session.put("notificacoes", this.getLoginBean().getNotificacoes());
			session.put("loggedIn",true);
			System.out.println("return bom");
			return "loginSuccess";
		}
		return "loginError";
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = Security.SHA1(password);
	}

	public LoginBean getLoginBean()
	{
		if(!session.containsKey("loginBean"))
		{
			this.setLoginBean(new LoginBean());
		}
		return (LoginBean) session.get("loginBean");
	}

	public void setLoginBean(LoginBean loginBean)
	{
		this.session.put("loginBean",loginBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
