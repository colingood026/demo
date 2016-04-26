package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;

import com.google.common.base.Stopwatch;
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
	//json
	private ConvertToJson ConvertToJson=new ConvertToJson();
	//jdbc
	private INV_ITEM_DAO dao=new INV_ITEM_DAO();
	//mybatis
//	private INV_ITEM_Service iNV_ITEM_Service=new INV_ITEM_Service();

	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public String execute() throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		List<INV_ITEM_VO> item=null;
		//jdbc
		if(MAT_01==null&&COL_NO==null){			
			item=dao.select_all();				
		}else if(MAT_01.length()!=0&&COL_NO.length()!=0){
			item=dao.select_by_2condition("COL_NO",COL_NO,"MAT_01", MAT_01);
		}else if(MAT_01.length()!=0){
			item=dao.select_by_1condition("MAT_01",MAT_01);
		}else if(COL_NO.length()!=0){
			item=dao.select_by_1condition("COL_NO",COL_NO);
		}
		//jdbc end
		//mybatis
//		Map<String,Object> map=new HashMap<String,Object>();
//		if(MAT_01==null&&COL_NO==null){			
//		}else if(MAT_01.length()!=0&&COL_NO.length()!=0){
//			map.put("COL_NO", COL_NO);
//			map.put("MAT_01", MAT_01);			
//		}else if(MAT_01.length()!=0){
//			map.put("MAT_01", MAT_01);			
//		}else if(COL_NO.length()!=0){
//			map.put("COL_NO", COL_NO);			
//		}
//		item=iNV_ITEM_Service.select_INV_ITEM(map);
		//mybatis end
		
		if(item!=null){			
			String jsonString=ConvertToJson.toJson(item);			
			response.getWriter().print(jsonString);
		}
		return Action.NONE;
	}
	
	
	
}
