package service;

import java.util.ArrayList;

import dao.WasherDao;
import entity.Washer;
import utils.Page;

public class WasherService {
	WasherDao washerDao=new WasherDao();

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
}
