package dao.factory;

import dao.dao.LoverDao;
import dao.imp.LoverDaoSerImpl;

public class LoverDaoFactory {
	public static LoverDao getLoverDao() {
		return new LoverDaoSerImpl();
	}
}
