package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.WasherDao;
import entity.User;
import entity.Washer;

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
		// http://localhost:8080/equip/typeList.do
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
			throw new RuntimeException("调用方法出错！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void dashboardServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/page/dashboard.jsp").forward(request, response);	
	}

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
				out.write("yes");
			}else
				out.write("no");
		}finally {
			out.close();
		}
	}
	
	protected void selectAllWasherServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Washer> washer=new WasherDao().query_all();
		request.setAttribute("washer", washer);
		request.getRequestDispatcher("typeList.jsp").forward(request, response);
	}

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
}

