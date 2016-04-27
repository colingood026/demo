package model;

import java.io.InputStream;
import java.io.ObjectInputStream;
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

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import com.google.common.base.Stopwatch;

import util.ConvertToJson;
import util.jdbcClose;

public class INV_ITEM_jdbcDAO {
	private jdbcClose jdbcClose=new jdbcClose();
	private static final ObjectMapper mapper = new ObjectMapper();
	private static ConvertToJson ConvertToJson=new ConvertToJson();
	//
//	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=QMI_POC";
//	private final String USER="sa";
//	private final String PASSWORD="123qweaS";
	//DataSource
	private DataSource ds=null;
	public INV_ITEM_jdbcDAO(){
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	//SELECT_ALL
	private static final String SELECT_ALL="select * from INV_ITEM ";
	public List<INV_ITEM_VO> select_all(){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//DataSource
			conn=ds.getConnection();
			stmt=conn.prepareStatement(SELECT_ALL);
			rs=stmt.executeQuery();
			result=getResult(result,rs);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{						
			jdbcClose.allClose(conn, stmt, rs);			
		}		
		return result;
	}
	//--------------單一條件查詢
	private static final String SELECT_BY_CONDITION="select * from INV_ITEM where ";
	public List<INV_ITEM_VO> select_by_1condition(String column,String value){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		StringBuilder sb=new StringBuilder(SELECT_BY_CONDITION);
		getCol(sb,column);		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//DataSource
			conn=ds.getConnection();
			stmt=conn.prepareStatement(sb.toString());
			stmt.setString(1, value);
			rs=stmt.executeQuery();			
			result=getResult(result,rs);			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{						
			jdbcClose.allClose(conn, stmt, rs);			
		}		
		return result;
	}		
	//--------------------------兩個條件查詢
	public List<INV_ITEM_VO> select_by_2condition(String column1,String value1,String column2,String value2){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		StringBuilder sb=new StringBuilder(SELECT_BY_CONDITION);
		getCol(sb,column1);
		sb.append(" and ");
		getCol(sb,column2);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//DataSource
			conn=ds.getConnection();
			stmt=conn.prepareStatement(sb.toString());
			stmt.setString(1, value1);
			stmt.setString(2, value2);
			rs=stmt.executeQuery();			
			result=getResult(result,rs);			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{						
			jdbcClose.allClose(conn, stmt, rs);			
		}		
		return result;
	}
	//for 動態查詢
	private StringBuilder getCol(StringBuilder sb,String column){
		if(column=="COL_NO"){
			sb.append("COL_NO=?");
		}else if(column=="MAT_01"){
			sb.append("MAT_01=?");
		}
		return sb;
	}
	//
	private List<INV_ITEM_VO> getResult(List<INV_ITEM_VO> result,ResultSet rs) throws SQLException{
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
		return result;
	}
	//-------------------test------------------------
	public static void main(String args[]){
		INV_ITEM_jdbcDAO dao=new INV_ITEM_jdbcDAO();
		
		List<INV_ITEM_VO> allEquip=dao.select_by_2condition("MAT_01","S-2727","COL_NO","001-BT");
		INV_ITEM_VO bean=new INV_ITEM_VO();
		

		System.out.println(bean.getCNT_NO());
		
		
		
		
		
		
	}
	
}
