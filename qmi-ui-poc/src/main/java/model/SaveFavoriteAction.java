package model;



import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class SaveFavoriteAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private accountDAO accountDAO=new accountDAO();
	private String newColumn;
	
	
	

	public String getNewColumn() {
		return newColumn;
	}
	public void setNewColumn(String newColumn) {
		this.newColumn = newColumn;
	}
	private Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	@Override
	public String execute() throws Exception {
		StringBuilder preference=new StringBuilder();
		//取得使用者資訊
		accountVO user=(accountVO)session.get("bean");
		//拆解json
		JSONSerializer jSONSerializer=new JSONSerializer();
		Object b=null;		
		try {//將data轉換Object
			b=jSONSerializer.toJSON(newColumn);
		} catch (Exception e) {			
			System.out.println("jSONSerializer error="+e.toString());
		}		
		JSONArray jSONArray=JSONArray.fromObject(b);//將Object轉換成JsonArray格式
		for(int i=0;i<jSONArray.size();i++){
			if(i==jSONArray.size()-1){
				preference.append((String)jSONArray.get(i));
			}else{
				preference.append((String)jSONArray.get(i)).append(",");
			}						
		}
		//更新資料庫
		System.out.println(accountDAO.update(preference.toString(), user.getAccount()));	
		
		return Action.NONE;
	}



}