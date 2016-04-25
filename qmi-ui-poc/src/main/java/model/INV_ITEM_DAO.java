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

import com.google.common.base.Stopwatch;

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
	//SELECT_ALL
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
	//--------------用色號搜巡SELECT_BY_COL_NO
	private static final String SELECT_BY_COL_NO="select * from INV_ITEM where COL_NO=?";
	public List<INV_ITEM_VO> select_by_colNo(String colNo){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
//			conn=ds.getConnection();
			stmt=conn.prepareStatement(SELECT_BY_COL_NO);
			stmt.setString(1, colNo);
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
	//--------------------------用料號搜尋SELECT_BY_MAT_01
	private static final String SELECT_BY_MAT_01="select * from INV_ITEM where MAT_01=?";
	public List<INV_ITEM_VO> select_by_mat01(String mat01){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
//			conn=ds.getConnection();
			stmt=conn.prepareStatement(SELECT_BY_MAT_01);
			stmt.setString(1, mat01);
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
	//--------------------------料號+色號搜尋SELECT_BY_COL_NO_AND_MAT_01
	private static final String SELECT_BY_COL_NO_AND_MAT_01="select * from INV_ITEM where COL_NO=? and MAT_01=?";
	public List<INV_ITEM_VO> select_by_colNoAndmat01(String colNo,String mat01){
		List<INV_ITEM_VO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
//			conn=ds.getConnection();
			stmt=conn.prepareStatement(SELECT_BY_COL_NO_AND_MAT_01);
			stmt.setString(1, colNo);
			stmt.setString(2, mat01);
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
		INV_ITEM_DAO dao=new INV_ITEM_DAO();
		
		List<INV_ITEM_VO> allEquip=dao.select_all();
		
//		JSONArray json=new JSONArray(allEquip);
		System.out.println("allEquip="+allEquip);
		
		
		
		
	}
	
}
