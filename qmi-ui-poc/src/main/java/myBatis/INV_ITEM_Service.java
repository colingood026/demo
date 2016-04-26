package myBatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.INV_ITEM_VO;
import util.MyBatisSqlSessionFactory;

public class INV_ITEM_Service implements INV_ITEM_MDAO{
//	public List<INV_ITEM_VO> findAllINV_ITEM(){
//		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
//		
//		try {
//			INV_ITEM_MDAO equipmentMapper =sqlSession.getMapper(INV_ITEM_MDAO.class);
//			return equipmentMapper.findAllINV_ITEM();
//		} finally{
//			sqlSession.close();
//		}
//	};
	
	public List<INV_ITEM_VO> select_INV_ITEM(Map<String,Object> map) {
		// TODO:[colin.lee], Auto-generated method stub
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();		
		try {
			INV_ITEM_MDAO equipmentMapper =sqlSession.getMapper(INV_ITEM_MDAO.class);
			return equipmentMapper.select_INV_ITEM(map);
		} finally{
			sqlSession.close();
		}
	}
	
	public static void main(String args[]){
		INV_ITEM_Service service=new INV_ITEM_Service();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("MAT_01", "S-2727");
//		map.put("COL_NO", "001-BT");
		System.out.println(service.select_INV_ITEM(map));
	}
	
	
}
