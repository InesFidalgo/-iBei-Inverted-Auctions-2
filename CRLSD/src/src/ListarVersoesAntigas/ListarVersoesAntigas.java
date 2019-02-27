/**
 * Raul Barbosa 2014-11-07
 */
package src.ListarVersoesAntigas;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import java.util.Random;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import src.CreateLeilao.*;

public class ListarVersoesAntigas extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	
	
	public int id;
	
	public String type;
	
	
	@Override
	public String execute() throws Exception
	{
		
		System.out.println(this.id);
		this.getListarVersoesAntigasBean().setId(this.id);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getListarVersoesAntigasBean().listarVersoesAntigas())
		{
			return "listarVersoesAntigasSuccess";
		}
		return "listarVersoesAntigasError";
		
	}
	
	/*
	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}*/

	
	public void setId(int id){
		this.id=id;
	}
	
	
	public void setType(){
		this.type="older_versions";
	}
	
	

	public ListarVersoesAntigasBean getListarVersoesAntigasBean()
	{
		
		if(!session.containsKey("listarVersoesAntigasBean"))
		{
			this.setListarVersoesAntigasBean(new ListarVersoesAntigasBean());
		}
		return (ListarVersoesAntigasBean) session.get("listarVersoesAntigasBean");
	}

	public void setListarVersoesAntigasBean(ListarVersoesAntigasBean listarVersoesAntigasBean)
	{
		this.session.put("listarVersoesAntigasBean",listarVersoesAntigasBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
