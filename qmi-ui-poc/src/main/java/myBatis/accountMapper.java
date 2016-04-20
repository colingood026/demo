package myBatis;

import model.accountVO;

public interface accountMapper {
	accountVO findAccountById(String id);
}
