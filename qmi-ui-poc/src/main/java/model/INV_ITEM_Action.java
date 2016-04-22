package model;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import myBatis.INV_ITEM_Service;

public class INV_ITEM_Action extends ActionSupport implements ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//jdbc
	private INV_ITEM_DAO dao=new INV_ITEM_DAO();
	//mybatis
//	private INV_ITEM_Service service=new INV_ITEM_Service();
	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public String execute() throws Exception {
		//jdbc
		List<INV_ITEM_VO> allEquip=dao.select_all();
		//mybatis
//		List<INV_ITEM_VO> allEquip=service.findAllINV_ITEM();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		JSONArray json=new JSONArray(allEquip);
		response.getWriter().print(json);
		return Action.NONE;
	}
	
	
	
}
