package model;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accout;
	private String password;
	
	public String getAccout() {
		return accout;
	}

	public void setAccout(String accout) {
		this.accout = accout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session=session;		
	}


	@Override
	public String execute() throws Exception {
		//存入使用者名稱
		session.put("accout", accout);
		return Action.SUCCESS;
	}
	
	
	
	

}
