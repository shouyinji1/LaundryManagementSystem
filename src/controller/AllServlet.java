package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;

import dao.UserDao;
import dao.WasherDao;
import entity.Dashboard;
import entity.Page;
import entity.User;
import entity.Washer;
import service.WasherService;

/**
 * Servlet implementation class AllServlet
 */
@WebServlet("*.do")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WasherService washerService=new WasherService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllServlet() {
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
	
	/** 普通用户、管理员首页跳转 */
	protected void dashboardServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		Dashboard dashboard=new Dashboard();
		switch (user.getLevel()) {
		case "admin":	// 如果是管理员
			dashboard.setBrand("洗衣房管理");
			break;
		default:	// 默认为普通用户
			dashboard.setBrand("欢迎光临！");
			break;
		}
		request.getSession().setAttribute("dashboardInfo", dashboard);
		request.getRequestDispatcher("WEB-INF/page/dashboard.jsp").forward(request, response);	
	}
	
	/** 登录servlet */
	protected void loginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String level = request.getParameter("level");
		PrintWriter out= response.getWriter();
		try {
			UserDao userDao=new UserDao();
			User user=userDao.login(username, password, level);
			if(user != null) {
				request.getSession().setAttribute("user", user);
				//System.out.println(request.getSession().getAttribute("user"));
				out.write("yes");
			}else
				out.write("no");
		}finally {
			out.close();
		}
	}

	/** 退出登录 */
	protected void logoutServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("dashboardInfo");
		//request.getRequestDispatcher("login.html").forward(request, response);
		response.sendRedirect("login.html");
	}

	/** 注册普通用户 */
	protected void registerServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out= response.getWriter();
		try {
			UserDao userDao=new UserDao();
			int flag=userDao.register(username, password, "user");
			if(flag==1) {
				out.write("yes");
			}else
				out.write("no");
		}finally {
			out.close();
		}
	}

	/** 分页查询洗衣机信息 */
	protected void washerListServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("/WEB-INF/page/typeList.jsp").forward(request, response);
	}

	/** 删除洗衣机信息 */
	protected void deleteByIdServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		int flag=new WasherDao().deleteById(id);
		PrintWriter out= response.getWriter();
		if(flag==1) {
			out.write("yes");
		}else {
			out.write("no");
		}
	}
	
	//新增跳转
	public void toAddWasher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/page/washerAdd.jsp").forward(request, response);
	}
	
	//新增数据
	public void washerAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String status=request.getParameter("status");
		Washer washer=new Washer();
		
		washer.setStatus(status);
		
		WasherDao washerDao=new WasherDao();
		int result=washerDao.insertWasher(washer);
		if(result>0) {
			response.sendRedirect("washerListServlet.do");
		}else {
			response.getWriter().write("系统异常，新增数据失败，3秒后跳回页面");
			response.setHeader("refresh", "3;toAddType.do");
		}
	}
	
	//更新页面跳转
	public void updateWasher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String  id=	request.getParameter("id");
		Washer washer=new WasherDao().queryWasherInfoById(Integer.parseInt(id));
		request.setAttribute("washer", washer);
		request.getRequestDispatcher("/WEB-INF/page/washerUpdate.jsp").forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/page/washerAdd.jsp").forward(request, response);
	}
	
	/** 保存修改的洗衣机数据 */
	public void updateWasherById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取到参数
		request.setCharacterEncoding("UTF-8");
		String id =request.getParameter("id");
		String status=	request.getParameter("status");
		
		Washer washer=new Washer();
		washer.setId(id);
		washer.setStatus(status);
		int result=0;
		result = new WasherDao().updateById(status, id);
		if(result>0){
			//重定向   在此sevlet方法中调用另外一个方法
			response.sendRedirect("washerListServlet.do");
		}else{
			response.getWriter().write("系统异常,保存数据失败,3秒后跳转回修改页面");
			response.setHeader("refresh", "3;url=washerListServlet.do");
		}
	}
	
	/** 获取用户个人信息跳转 */
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("WEB-INF/page/userInfo.jsp").forward(request, response);
	}

	/** 更新用户信息 */
	public void toUpdateUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("user");
		String id=user.getId();
		String username=request.getParameter("username");
		String tel=request.getParameter("tel");
		UserDao userDao=new UserDao();
		int flag=userDao.updateUserInfo(username, tel,id);
		if(flag==1) {
			response.getWriter().write("yes");
			user.setName(username);
			user.setTel(tel);
			request.getSession().setAttribute("user", user);
		}else {
			response.getWriter().write("no");
		}
	}
	
	/** 更新密码 */
	public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String newPassword=request.getParameter("newpassword");
		UserDao userDao=new UserDao();
		int flag=userDao.updatePassword(id,newPassword);
		if(flag==1) {
			response.getWriter().write("yes");
		}else {
			response.getWriter().write("no");
		}
	}
}

