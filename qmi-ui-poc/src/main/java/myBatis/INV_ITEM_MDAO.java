package myBatis;

import java.util.List;
import java.util.Map;

import model.INV_ITEM_VO;

public interface INV_ITEM_MDAO {
//	List<INV_ITEM_VO> findAllINV_ITEM();
	List<INV_ITEM_VO> select_INV_ITEM(Map<String,Object> map);
}
