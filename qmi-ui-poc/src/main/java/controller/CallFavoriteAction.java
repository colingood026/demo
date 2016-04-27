package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import JDBC.account_jdbcDAO;
import model.accountVO;

public class CallFavoriteAction extends ActionSupport implements SessionAware,ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private account_jdbcDAO accountDAO=new account_jdbcDAO();
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
		Map<Integer,String> map=new HashMap<Integer,String>();
		SortedMap<Integer, String> sortedMap=null;
		String jsonString=null;
		if(preference==null){
			int i=99;
			map.put(i, "none");
			jsonString=mapper.writeValueAsString(map);			
		}else{			
			int i=1;
			for(String a:preference.split(",")){
				map.put(i, a);
				i++;
			}			
			sortedMap=new TreeMap<Integer,String>();
			sortedMap.putAll(map);			
			jsonString=mapper.writeValueAsString(sortedMap);			
		}
		System.out.println("sortedMap="+sortedMap);
		response.getWriter().print(jsonString);
		response.getWriter().flush();
		response.getWriter().close();
		
		
		
		return Action.NONE;
	}

	
	
	
}
