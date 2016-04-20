package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class accountDAO {
	private jdbcClose jdbcClose=new jdbcClose();
	//
	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=QMI_POC";
	private final String USER="sa";
	private final String PASSWORD="123qweaS";
	
	
	private final String SELECT_BY_ID="select * from account where account=?";
	public accountVO select_by_id(String id){
		accountVO result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			stmt=conn.prepareStatement(SELECT_BY_ID);
			
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next()){
				result=new accountVO();
				result.setAccount(rs.getString("account"));
				result.setFavorite(rs.getString("favorite"));
				result.setPswd(rs.getString("pswd"));
			}			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			jdbcClose.allClose(conn, stmt, rs);
		}		
		return result;
	}
	
	
	//--------------------------
	public static void main(String args[]){
		accountDAO dao=new accountDAO();
		System.out.println(dao.select_by_id("bbb"));
	}
}
