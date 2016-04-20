package model;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class equipmentAction extends ActionSupport implements ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private equipmentDAO dao=new equipmentDAO();
	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public String execute() throws Exception {
		List<equipmentVO> allEquip=dao.select_all();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		JSONArray json=new JSONArray(allEquip);
		response.getWriter().print(json);
		return Action.NONE;
	}
	
	
	
}
