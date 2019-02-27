/**
 * Raul Barbosa 2014-11-07
 */
package src.SearchLeilaoUser;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import src.CreateLeilao.*;

public class SearchLeilaoUser extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;

	
	public ArrayList<Leilao> auxa = null;
	
	public String login ;
	
	public String type;
	
	
	@Override
	public String execute() throws Exception
	{
		
		this.login = (String)this.session.get("login");
		this.getSearchLeilaoUserBean().setLogin(this.login);
		
		
		System.out.println(this.login);
		
		
		if((this.getSearchLeilaoUserBean().searchLeilaoUser().size()>0))
		{
		
			return "searchLeilaoUserSuccess";
		}
		else{
			return "searchLeilaoUserError";
		}
		
		
	}
	
	
	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public void setLeiloes(ArrayList<Leilao> aux){
		this.auxa=aux;
	}
	
	
	public void setType(){
		this.type="search_user_detail";
	}
	

	public SearchLeilaoUserBean getSearchLeilaoUserBean()
	{
		
		if(!session.containsKey("searchLeilaoUserBean"))
		{
			this.setSearchLeilaoUserBean(new SearchLeilaoUserBean());
		}
		return (SearchLeilaoUserBean) session.get("searchLeilaoUserBean");
	}

	public void setSearchLeilaoUserBean(SearchLeilaoUserBean searchLeilaoUserBean)
	{
		this.session.put("searchLeilaoUserBean",searchLeilaoUserBean);
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
