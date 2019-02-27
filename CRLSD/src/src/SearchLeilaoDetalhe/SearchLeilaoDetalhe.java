/**
 * Raul Barbosa 2014-11-07
 */
package src.SearchLeilaoDetalhe;

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

public class SearchLeilaoDetalhe extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	
	
	public int id;
	
	public String type;
	
	
	@Override
	public String execute() throws Exception
	{
		
		System.out.println(this.id);
		this.getSearchLeilaoDetalheBean().setId(this.id);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getSearchLeilaoDetalheBean().searchLeilaoDetalhe())
		{
			
			return "searchLeilaoDetalheSuccess";
		}
		return "searchLeilaoDetalheError";
		
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
		this.type="search_detail";
	}
	
	

	public SearchLeilaoDetalheBean getSearchLeilaoDetalheBean()
	{
		
		if(!session.containsKey("searchLeilaoDetalheBean"))
		{
			this.setSearchLeilaoDetalheBean(new SearchLeilaoDetalheBean());
		}
		return (SearchLeilaoDetalheBean) session.get("searchLeilaoDetalheBean");
	}

	public void setSearchLeilaoDetalheBean(SearchLeilaoDetalheBean searchLeilaoDetalheBean)
	{
		this.session.put("searchLeilaoDetalheBean",searchLeilaoDetalheBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
