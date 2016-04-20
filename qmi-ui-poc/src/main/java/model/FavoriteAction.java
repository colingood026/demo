package model;



import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

public class FavoriteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String allColumns;
	
	
	public String getAllColumns() {
		return allColumns;
	}


	public void setAllColumns(String allColumns) {
		this.allColumns = allColumns;
	}


	@Override
	public String execute() throws Exception {
		
		return Action.NONE;
	}

}
