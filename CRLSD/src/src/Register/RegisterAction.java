package src.Register;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import rmi.Security;

public class RegisterAction extends ActionSupport implements SessionAware
{
	private static final String REGISTER = "register";
	private Map<String,Object> session;
	private String login=null, password=null;

	@Override
	public String execute() throws Exception
	{
		this.getRegisterBean().setLogin(this.login);
		this.getRegisterBean().setPassword(this.password);
		if(this.getRegisterBean().getSuccessfulRegister())
		{
			return "registerSuccess";
		}
		return "registerError";
	}

	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public RegisterBean getRegisterBean()
	{
		if(!session.containsKey("registerBean"))
		{
			this.setRegisterBean(new RegisterBean());
		}
		return (RegisterBean)session.get("registerBean");
	}

	public void setRegisterBean(RegisterBean registerBean)
	{
		this.session.put("registerBean",registerBean);
	}

	@Override
	public void setSession(Map<String,Object> session)
	{
		this.session = session;
	}
}
