package controller;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import model.account_jdbcDAO;
import model.accountVO;

public class LoginAction extends ActionSupport implements SessionAware,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private account_jdbcDAO dao=new account_jdbcDAO();

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
	private Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}

	@Override
	public String execute() throws Exception {
		
		accountVO bean=dao.select_by_id(accout);
		
		if(bean==null){//比對使用者名稱
			request.put("errorAccount", "無此帳號");
			return Action.ERROR;
		}else if(bean.getPswd().equals(password)){//比對使用者密碼
			//存入使用者名稱
			session.put("bean", bean);
			return Action.SUCCESS;
		}else{
			request.put("errorPSWD", "密碼錯誤");
			return Action.ERROR;
		} 		
		
		
	}

	
	
	
	

}
