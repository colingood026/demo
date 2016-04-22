package myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.INV_ITEM_VO;
import util.MyBatisSqlSessionFactory;

public class INV_ITEM_Service {
	public List<INV_ITEM_VO> findAllINV_ITEM(){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		
		try {
			INV_ITEM_Mapper equipmentMapper =sqlSession.getMapper(INV_ITEM_Mapper.class);
			return equipmentMapper.findAllINV_ITEM();
		} finally{
			sqlSession.close();
		}
	};
	
	
	public static void main(String args[]){
		INV_ITEM_Service service=new INV_ITEM_Service();
		System.out.println(service.findAllINV_ITEM());
	}
}
