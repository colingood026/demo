package myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.equipmentVO;
import util.MyBatisSqlSessionFactory;

public class equipmentService {
	public List<equipmentVO> findAllEquipment(){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		
		try {
			equipmentMapper equipmentMapper =sqlSession.getMapper(equipmentMapper.class);
			return equipmentMapper.findAllEquipment();
		} finally{
			sqlSession.close();
		}
	};
	
	
	public static void main(String args[]){
		equipmentService service=new equipmentService();
		System.out.println(service.findAllEquipment());
	}
}
