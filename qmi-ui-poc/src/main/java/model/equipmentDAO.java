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

public class equipmentDAO {
	private jdbcClose jdbcClose=new jdbcClose();
	//
//	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=QMI_POC";
//	private final String USER="sa";
//	private final String PASSWORD="123qweaS";
	//DataSource
	private DataSource ds=null;
	public equipmentDAO(){
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	
	private final String SELECT_ALL="select * from equipment";
	public List<equipmentVO> select_all(){
		List<equipmentVO> result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			conn=ds.getConnection();
			stmt=conn.prepareStatement(SELECT_ALL);
			
			rs=stmt.executeQuery();
			result=new ArrayList<equipmentVO>();
			while(rs.next()){
				equipmentVO bean=new equipmentVO();
				bean.setAmount(rs.getDouble("amount"));
				bean.setBox_no(rs.getString("box_no"));
				bean.setBuy_date(rs.getDate("buy_date"));
				bean.setBuy_no(rs.getString("buy_no"));
				bean.setColor(rs.getString("color"));
				bean.setCylinder_no(rs.getString("cylinder_no"));
				bean.setEq_no(rs.getString("eq_no"));
				bean.setStored(rs.getString("stored"));
				bean.setUnit(rs.getString("unit"));
				bean.setWidth(rs.getString("width"));
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
		equipmentDAO dao=new equipmentDAO();
		List<equipmentVO> allEquip=dao.select_all();
		JSONArray json=new JSONArray(allEquip);
		System.out.println("json="+json);
		
		
		
		
	}
	
}
