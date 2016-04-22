package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONArray;

public class INV_ITEM_DAO {
	private jdbcClose jdbcClose=new jdbcClose();
	//
	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=QMI_POC";
	private final String USER="sa";
	private final String PASSWORD="123qweaS";
	//DataSource
//	private DataSource ds=null;
//	public equipmentDAO(){
//		try {
//			Context ctx=new InitialContext();
//			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xxx");
//		} catch (NamingException e) {			
//			e.printStackTrace();
//		}
//	}
	
	private final String SELECT_ALL="select * from INV_ITEM";
	public List<INV_ITEM_VO> select_all(){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
//			conn=ds.getConnection();
			stmt=conn.prepareStatement(SELECT_ALL);
			
			rs=stmt.executeQuery();
			result=new ArrayList<INV_ITEM_VO>();
			while(rs.next()){
				INV_ITEM_VO bean=new INV_ITEM_VO();
				bean.setCNT_NO(rs.getString("CNT_NO"));
				bean.setCOL_NO(rs.getString("COL_NO"));
				bean.setLOC_CODE(rs.getString("LOC_CODE"));
				bean.setLOT_ID(rs.getString("LOT_ID"));
				bean.setMAT_01(rs.getString("MAT_01"));
				bean.setPUR_NO(rs.getString("PUR_NO"));
				bean.setREC_DATE(rs.getDate("REC_DATE"));
				bean.setSTOCK_QTY(rs.getDouble("STOCK_QTY"));
				bean.setUNT_RQ(rs.getString("UNT_RQ"));
				bean.setWID_TH(rs.getDouble("WID_TH"));
				result.add(bean);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} finally{						
			jdbcClose.allClose(conn, stmt, rs);
			
		}		
		return result;
	}
	
	
	
	
	//-------------------test------------------------
	public static void main(String args[]){
		INV_ITEM_DAO dao=new INV_ITEM_DAO();
		List<INV_ITEM_VO> allEquip=dao.select_all();
//		JSONArray json=new JSONArray(allEquip);
		System.out.println("allEquip="+allEquip);
		
		
		
		
	}
	
}
