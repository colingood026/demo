package myBatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.accountVO;
import util.MyBatisSqlSessionFactory;

public class accountService implements accountMDAO{
	public accountVO findAccountById(String account){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		
		try {
			accountMDAO accountMapper=sqlSession.getMapper(accountMDAO.class);
			return accountMapper.findAccountById(account);
		} finally{
			sqlSession.close();
		}
	}

	public void updateFavorite(accountVO account) {
		// TODO:[colin.lee], Auto-generated method stub
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();		
		try {
			accountMDAO accountMapper=sqlSession.getMapper(accountMDAO.class);
			accountMapper.updateFavorite(account);
			//沒有commit就不會寫到資料庫
			sqlSession.commit();
		} finally{
			sqlSession.close();
		}		
	}
	
	
	public static void main(String args[]){
		accountService service=new accountService();
		accountVO bean=service.findAccountById("Alex");
		bean.setFavorite("kkk");
		service.updateFavorite(bean);
		System.out.println(service.findAccountById("Alex"));
	}




}
