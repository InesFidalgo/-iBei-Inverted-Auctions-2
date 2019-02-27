package src.LoginAdmin;

import com.opensymphony.xwork2.ActionSupport;


import java.util.Random;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import rmi.Security;
import webSocket.WebSocketAnnotation;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String login=null, password=null;

	@Override
	public String execute() throws Exception
	{
		WebSocketAnnotation a = new WebSocketAnnotation();
		this.getLoginAdminBean().setLogin(this.login);
		this.getLoginAdminBean().setPassword(this.password);
		if(this.getLoginAdminBean().tryLogin())
		{
			System.out.println("login hhhh"+this.login);
			session.put("login",this.login);
			session.put("notificacoes", this.getLoginAdminBean().getNotificacoes());
			session.put("Socket", a);
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

	public LoginBean getLoginAdminBean()
	{
		if(!session.containsKey("loginAdminBean"))
		{
			this.setLoginAdminBean(new LoginBean());
		}
		return (LoginBean) session.get("loginAdminBean");
	}

	public void setLoginAdminBean(LoginBean loginAdminBean)
	{
		this.session.put("loginAdminBean",loginAdminBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
