package myBatis;

import java.util.List;

import model.equipmentVO;

public interface equipmentMapper {
	List<equipmentVO> findAllEquipment();
}
