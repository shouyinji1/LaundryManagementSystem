package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.Dashboard;
import entity.User;

/**
 * Servlet implementation class AllServlet
 */
@WebServlet("*.do")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		dashboard.setLevel(user.getLevel());
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

