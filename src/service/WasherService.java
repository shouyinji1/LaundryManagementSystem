package service;

import java.util.ArrayList;

import dao.WasherDao;
import entity.Page;
import entity.Washer;

/** 洗衣机服务 */
public class WasherService {
	WasherDao washerDao=new WasherDao();

	/** 管理员的洗衣机信息查询服务 */
	public Page<Washer> getWasherPage(Page<Washer> page){
		//查询当前页的列表数据
		ArrayList<Washer> data = washerDao.querySplitedList(
				(page.getCurPage()-1)*page.getPageSize(),
				page.getPageSize());
		//查询总记录数
		int rowsCount = washerDao.queryInfosCount();
		//将分页信息封装到page对象中
		page.setParam(data,rowsCount);
		return page;
	}

	/** 用户的洗衣机信息查询服务 */
	public Page<Washer> getWasherPage(Page<Washer> page,String userID){
		//查询当前页的列表数据
		ArrayList<Washer> data = washerDao.querySplitedList(
				userID,
				(page.getCurPage()-1)*page.getPageSize(),
				page.getPageSize());
		//查询总记录数
		int rowsCount = washerDao.queryInfosCount();
		//将分页信息封装到page对象中
		page.setParam(data,rowsCount);
		return page;
	}
}
