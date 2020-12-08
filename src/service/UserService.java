package service;

import java.util.ArrayList;

import dao.UserDao;
import entity.Page;
import entity.User;

/** 用户服务 */
public class UserService {
	UserDao userDao=new UserDao();

	/** 管理员的普通用户信息查询服务 */
	public Page<User> getUserPage(Page<User> page){
		//查询当前页的列表数据
		ArrayList<User> data = userDao.querySplitedListOfNormalUser(
				(page.getCurPage()-1)*page.getPageSize(),
				page.getPageSize());
		//查询总记录数
		int rowsCount = userDao.queryInfosCountOfNormalUser();
		//将分页信息封装到page对象中
		page.setParam(data,rowsCount);
		return page;
	}

}
