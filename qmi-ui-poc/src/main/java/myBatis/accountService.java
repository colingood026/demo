package myBatis;

import org.apache.ibatis.session.SqlSession;

import model.accountVO;
import util.MyBatisSqlSessionFactory;

public class accountService {
	public accountVO findAccountById(String account){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		
		try {
			accountMapper accountMapper=sqlSession.getMapper(accountMapper.class);
			return accountMapper.findAccountById(account);
		} finally{
			sqlSession.close();
		}
	}
	
	
	
	public static void main(String args[]){
		accountService service=new accountService();
		System.out.println(service.findAccountById("Alex"));
	}
}
