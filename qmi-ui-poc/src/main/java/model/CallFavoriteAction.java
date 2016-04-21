package model;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONArray;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CallFavoriteAction extends ActionSupport implements SessionAware,ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private accountDAO accountDAO=new accountDAO();
	
	
	private Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		// TODO:[colin.lee], Auto-generated method stub
		this.session=session;
	}
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	
	@Override
	public String execute() throws Exception {
		// TODO:[colin.lee], Auto-generated method stub
		accountVO user=(accountVO)session.get("bean");

		String preference=user.getFavorite();
		
		if(preference==null){
			response.getWriter().print("none");
		}else{
			response.getWriter().print(preference);
		}
		
		
		
		
		return Action.NONE;
	}

	
	
	
}
