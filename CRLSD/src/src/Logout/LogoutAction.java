package src.Logout;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.security.MessageDigest;
import java.util.Map;

public class LogoutAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String login=null;

	@Override
	public String execute() throws Exception
	{
		System.out.println("entrou no execute logout");
		this.login = (String)this.session.get("login");
		this.getLogoutBean().setLogin(this.login);
		
		if(this.getLogoutBean().logout())
		{
			session.remove("login");
			session.remove("password");
			
			session.remove("loggedIn");
			System.out.println("deu return bom logout");
			System.out.println("loggedin"+session.get("loggedIn"));
			
			return "logoutSuccess";
		}
		return "logoutError";
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public LogoutBean getLogoutBean()
	{
		if(!session.containsKey("logoutBean"))
		{
			this.setLogoutBean(new LogoutBean());
		}
		return (LogoutBean) session.get("logoutBean");
	}

	public void setLogoutBean(LogoutBean logoutBean)
	{
		this.session.put("logoutBean",logoutBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
