package service;

import java.util.ArrayList;

import dao.OrderDao;
import entity.Order;
import entity.Page;

/** 订单服务 */
public class OrderService {
	OrderDao orderDao=new OrderDao();

	/** 管理员的订单信息查询服务 */
	public Page<Order> getOrderPage(Page<Order> page){
		//查询当前页的列表数据
		ArrayList<Order> data = orderDao.querySplitedList(
				(page.getCurPage()-1)*page.getPageSize(),
				page.getPageSize());
		//查询总记录数
		int rowsCount = orderDao.queryInfosCount();
		//将分页信息封装到page对象中
		page.setParam(data,rowsCount);
		return page;
	}

	/** 用户的订单信息查询服务 */
	public Page<Order> getOrderPage(String userID,Page<Order> page){
		//查询当前页的列表数据
		ArrayList<Order> data = orderDao.querySplitedList(
				userID,
				(page.getCurPage()-1)*page.getPageSize(),
				page.getPageSize());
		//查询总记录数
		int rowsCount = orderDao.queryInfosCount();
		//将分页信息封装到page对象中
		page.setParam(data,rowsCount);
		return page;
	}
}
