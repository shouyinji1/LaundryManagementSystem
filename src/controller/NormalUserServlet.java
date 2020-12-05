package controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.PriceDao;
import dao.WasherDao;
import entity.Order;
import entity.Page;
import entity.Price;
import entity.User;
import entity.Washer;
import service.OrderService;
import service.WasherService;

/**
 * Servlet implementation class NormalUserServlet
 */
@WebServlet("*.normalUserServlet")
public class NormalUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	WasherService washerService=new WasherService();
	OrderService orderService=new OrderService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NormalUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求的URI地址信息
		// http://localhost:8080/equip/.do
		String url = request.getRequestURI();
		
		// 截取其中的方法名typeList
		String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
		Method method = null;
		try {
			// 使用反射机制获取在本类中声明了的方法
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			// 执行方法
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException("调用方法出错！"+methodName+"\n"+e.getLocalizedMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/** 分页查询洗衣机信息 */
	protected void washerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		// 获取分页对象
		Page<Washer> page = (Page<Washer>)request.getAttribute("page");
		//判断是否是第一次请求
		if (page == null) {
			page = new Page<Washer>(5);// 参数为每页显示数量
		}
		// 获取当前要查的页码
		String curPageStr = request.getParameter("curPage");
		if (curPageStr != null) {
			//如果不是第一次进入,将页面传过来的页码赋值给初始的第一页
			page.setCurPage(Integer.parseInt(curPageStr));
		}else {
			page.setCurPage(1);	//第一次进入的时候，默认为第一页
		}

		// 去数据库查询类型管理表，获取数据
		page = washerService.getWasherPage(page,user.getId());
		// 将数据返回给页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/normalUser/washerList.jsp").forward(request, response);
	}
	
	/** 撤销选择洗衣机 */
	protected void withdrawOrderByWasherID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String washerID=request.getParameter("id");
		int flag=new OrderDao().deleteByWasherID(washerID);
		if(flag==1) {
			response.getWriter().write("yes");
		}else {
			response.getWriter().write("no");
		}
	}
	
	/** 选择洗衣机 */
	protected void chooseWasher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=	request.getParameter("id");
		Washer washer=new WasherDao().queryWasherInfoById(id);
		request.setAttribute("washer", washer);
		ArrayList<Price> prices=new PriceDao().queryAll();
		request.setAttribute("prices", prices);
		request.getRequestDispatcher("/WEB-INF/page/normalUser/orderCreate.jsp").forward(request, response);
	}
	
	/** 创建订单 */
	protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userID=request.getParameter("userID");
		String washerID=request.getParameter("washerID");
		String mode=request.getParameter("mode");

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());	//获取当前时间
        
        int flag=new OrderDao().insert(userID, washerID, mode, date);
		if(flag==1){
			//重定向   在此sevlet方法中调用另外一个方法
			response.sendRedirect("washerList.normalUserServlet");
		}else{
			response.getWriter().write("系统异常,保存数据失败,3秒后跳转回修改页面"+flag);
			response.setHeader("refresh", "3;url=washerList.normalUserServlet");
		}
	}
	
	/** 分页查询洗衣机信息 */
	protected void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		// 获取分页对象
		Page<Order> page = (Page<Order>)request.getAttribute("page");
		//判断是否是第一次请求
		if (page == null) {
			page = new Page<Order>(5);// 参数为每页显示数量
		}
		// 获取当前要查的页码
		String curPageStr = request.getParameter("curPage");
		if (curPageStr != null) {
			//如果不是第一次进入,将页面传过来的页码赋值给初始的第一页
			page.setCurPage(Integer.parseInt(curPageStr));
		}else {
			page.setCurPage(1);	//第一次进入的时候，默认为第一页
		}

		// 去数据库查询类型管理表，获取数据
		page = orderService.getOrderPage(user.getId(),page);
		// 将数据返回给页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/normalUser/myOrders.jsp").forward(request, response);
	}
	
	/** 跳转至修改订单页面 */
	protected void toUpdateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Order order=new OrderDao().queryOrderInfoById(id);
		Washer washer=new WasherDao().queryWasherInfoById(order.getWasherID());
		ArrayList<Price> prices=new PriceDao().queryAll();
		// 将数据返回给页面
		request.setAttribute("order", order);
		request.setAttribute("washer", washer);
		request.setAttribute("prices", prices);
		request.getRequestDispatcher("/WEB-INF/page/normalUser/orderUpdate.jsp").forward(request, response);
	}
	
	/** 修改订单 */
	protected void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String orderID=request.getParameter("orderID");
		String mode=request.getParameter("mode");

        int flag=new OrderDao().update(orderID,mode);
		if(flag==1){
			//重定向   在此sevlet方法中调用另外一个方法
			response.sendRedirect("myOrders.normalUserServlet");
		}else{
			response.getWriter().write("系统异常,保存数据失败,3秒后跳转回修改页面"+flag);
			response.setHeader("refresh", "3;url=myOrders.normalUserServlet");
		}
	}

	/** 撤销订单 */
	protected void deleteOrderByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderID=request.getParameter("id");
		int flag=new OrderDao().deleteByID(orderID);
		if(flag==1) {
			response.getWriter().write("yes");
		}else {
			response.getWriter().write("no");
		}
	}
}
