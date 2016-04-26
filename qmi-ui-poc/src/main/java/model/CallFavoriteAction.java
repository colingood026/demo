package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CallFavoriteAction extends ActionSupport implements SessionAware,ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private accountDAO accountDAO=new accountDAO();
	private ObjectMapper mapper = new ObjectMapper();
	
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
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		accountVO user=(accountVO)session.get("bean");

		String preference=user.getFavorite();
		Map<String,String> map=new HashMap<String,String>();
		String jsonString=null;
		if(preference==null){
			map.put("none", "none");
			jsonString=mapper.writeValueAsString(map);			
		}else{			
			int i=1;
			for(String a:preference.split(",")){
				map.put("k"+i, a);
				i++;
			}			
			jsonString=mapper.writeValueAsString(map);			
		}
		response.getWriter().print(jsonString);
		response.getWriter().flush();
		response.getWriter().close();
		
		
		
		return Action.NONE;
	}

	
	
	
}
