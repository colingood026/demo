package model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import util.jdbcClose;

public class account_jdbcDAO {
	private jdbcClose jdbcClose=new jdbcClose();
	private static final ObjectMapper mapper = new ObjectMapper();
	//
//	private final String URL="jdbc:sqlserver://localhost:1433;databaseName=QMI_POC";
//	private final String USER="sa";
//	private final String PASSWORD="123qweaS";
	//DataSource
	private DataSource ds=null;
	public account_jdbcDAO(){
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}	
	
	private final String SELECT_BY_ID="select * from account where account=?";
	public accountVO select_by_id(String id){
		accountVO result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//DataSource
			conn=ds.getConnection();
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
	
	
	
	
	private static final String INSERT="update account set favorite=? where account=?";
	public boolean update(String favorite,String account){
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//DataSource
			conn=ds.getConnection();
			stmt=conn.prepareStatement(INSERT);
			stmt.setString(1, favorite);
			stmt.setString(2, account);
			int i=stmt.executeUpdate();
			if(i==1){
				result=true;
			}
				
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			jdbcClose.partClose(conn, stmt);
		}		
			
		
		return result;
		
		
	}
	
	//--------------------------
	public static void main(String args[]){
		account_jdbcDAO dao=new account_jdbcDAO();
		accountVO user=dao.select_by_id("Alex");
		try {
			//
			mapper.writeValue(new File("C:\\json\\user.json"), user);
			//
			String jsonString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			System.out.println("jsonString="+jsonString);			
		} catch (JsonGenerationException e) {
			// TODO:[colin.lee], Auto-generated try catch stub
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO:[colin.lee], Auto-generated try catch stub
			e.printStackTrace();
		} catch (IOException e) {
			// TODO:[colin.lee], Auto-generated try catch stub
			e.printStackTrace();
		}
	}
}
