package model;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import myBatis.equipmentService;

public class equipmentAction extends ActionSupport implements ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//jdbc
//	private equipmentDAO dao=new equipmentDAO();
	//mybatis
	private equipmentService service=new equipmentService();
	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public String execute() throws Exception {
		//jdbc
//		List<equipmentVO> allEquip=dao.select_all();
		//mybatis
		List<equipmentVO> allEquip=service.findAllEquipment();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		JSONArray json=new JSONArray(allEquip);
		response.getWriter().print(json);
		return Action.NONE;
	}
	
	
	
}
