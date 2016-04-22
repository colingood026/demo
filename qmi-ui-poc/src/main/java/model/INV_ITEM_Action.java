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
	private String MAT_01;
	private String COL_NO;
	public String getMAT_01() {
		return MAT_01;
	}
	public void setMAT_01(String mAT_01) {
		MAT_01 = mAT_01;
	}
	public String getCOL_NO() {
		return COL_NO;
	}
	public void setCOL_NO(String cOL_NO) {
		COL_NO = cOL_NO;
	}
	//jdbc
	private INV_ITEM_DAO dao=new INV_ITEM_DAO();

	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public String execute() throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONArray json=null;
		if(MAT_01==null&&COL_NO==null){
			json=new JSONArray(dao.select_all());
		}else if(MAT_01.length()!=0&&COL_NO.length()!=0){
			json=new JSONArray(dao.select_by_colNoAndmat01(COL_NO, MAT_01));
		}else if(MAT_01.length()!=0){
			json=new JSONArray(dao.select_by_mat01(MAT_01));
		}else if(COL_NO.length()!=0){
			json=new JSONArray(dao.select_by_colNo(COL_NO));
		}					
		if(json!=null){			
			response.getWriter().print(json);
		}
		return Action.NONE;
	}
	
	
	
}
