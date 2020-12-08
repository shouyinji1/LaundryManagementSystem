package service;

import java.util.ArrayList;

import dao.PriceDao;
import entity.Page;
import entity.Price;

/** 价目服务 */
public class PriceService {
	PriceDao priceDao=new PriceDao();

	/** 管理员的价目信息查询服务 */
	public Page<Price> getPricePage(Page<Price> page){
		//查询当前页的列表数据
		ArrayList<Price> data = priceDao.querySplitedList(
				(page.getCurPage()-1)*page.getPageSize(),
				page.getPageSize());
		//查询总记录数
		int rowsCount = priceDao.queryInfosCount();
		//将分页信息封装到page对象中
		page.setParam(data,rowsCount);
		return page;
	}
}
