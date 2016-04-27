package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import JDBC.INV_ITEM_jdbcDAO;
import util.ConvertToJson;

public class CallMAT_01Action extends ActionSupport implements ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//json
	private ObjectMapper mapper = new ObjectMapper();
	//jdbc
	private INV_ITEM_jdbcDAO dao=new INV_ITEM_jdbcDAO();
	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		// TODO:[colin.lee], Auto-generated method stub
		this.response=response;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO:[colin.lee], Auto-generated method stub
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		map.put("MAT_01", dao.distinctMAT_01());
		String jsonString=mapper.writeValueAsString(map);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonString);
		response.getWriter().flush();
		response.getWriter().close();
		return Action.NONE;
	}

	
}
