package myBatis;

import java.util.Map;

import model.accountVO;

public interface accountMDAO {
	accountVO findAccountById(String id);
	void updateFavorite(accountVO account);
}
