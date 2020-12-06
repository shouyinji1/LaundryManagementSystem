package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.UserDao;
import dao.WasherDao;
import entity.Order;
import entity.Page;
import entity.User;
import entity.Washer;
import service.OrderService;
import service.UserService;
import service.WasherService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("*.adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	WasherService washerService=new WasherService();
	OrderService orderService=new OrderService();
	UserService userService=new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		page = washerService.getWasherPage(page);
		// 将数据返回给页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/admin/washerList.jsp").forward(request, response);
	}

	/** 删除洗衣机信息 */
	protected void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		PrintWriter out= response.getWriter();
		int flag=new WasherDao().deleteById(id);
		if(flag==1) {
			out.write("yes");
		}else {
			out.write("no");
		}
	}
	
	/** 跳转至新增界面 */
	public void toAddWasher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/page/admin/washerAdd.jsp").forward(request, response);
	}
	
	//新增数据
	public void washerAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		Washer washer=new Washer();
		washer.setName(request.getParameter("name"));
		washer.setLocation(request.getParameter("location"));
		WasherDao washerDao=new WasherDao();
		int result=washerDao.insert(washer);
		if(result>0) {
			response.sendRedirect("washerList.adminServlet");
		}else {
			response.getWriter().write("系统异常，新增数据失败，3秒后跳回页面");
			response.setHeader("refresh", "3;toAddType.adminServlet");
		}
	}
	
	//更新页面跳转
	public void updateWasher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String  id=	request.getParameter("id");
		Washer washer=new WasherDao().queryWasherInfoById(id);
		request.setAttribute("washer", washer);
		request.getRequestDispatcher("/WEB-INF/page/admin/washerUpdate.jsp").forward(request, response);
	}
	
	/** 保存修改的洗衣机数据 */
	public void updateWasherById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取到参数
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id =request.getParameter("id");
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		
		Washer washer=new Washer();
		washer.setId(id);
		int result=0;
		result = new WasherDao().updateById(id,name,location);
		if(result>0){
			//重定向   在此sevlet方法中调用另外一个方法
			response.sendRedirect("washerList.adminServlet");
		}else{
			response.getWriter().write("系统异常,保存数据失败,3秒后跳转回修改页面"+result);
			response.setHeader("refresh", "3;url=washerList.adminServlet");
		}
	}
	
	
	/******************* 订单管理Servlet ***********************/

	/** 所有订单 */
	public void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		page = orderService.getOrderPage(page);
		// 将数据返回给页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/admin/orderList.jsp").forward(request, response);
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
	

	/**************** 用户管理 ****************/
	
	/** 所有订单 */
	public void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 获取分页对象
		Page<User> page = (Page<User>)request.getAttribute("page");
		//判断是否是第一次请求
		if (page == null) {
			page = new Page<User>(5);// 参数为每页显示数量
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
		page = userService.getUserPage(page);
		// 将数据返回给页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/admin/userList.jsp").forward(request, response);
	}

	/** 删除用户 */
	protected void deleteUserByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=request.getParameter("id");
		int flag=new UserDao().deleteByID(userID);
		if(flag==1) {
			response.getWriter().write("yes");
		}else {
			response.getWriter().write("no");
		}
	}
}
