package practice;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.cfg.DelayedLogItem.Level;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println("用户名"+username);
		
		String password=request.getParameter("password");
		System.out.println("密码"+password);
		System.out.println("-----------------");
		
		Enumeration<String> parameterNames=request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			System.out.println(parameterNames.nextElement());
		}
		System.out.println("-----------------");
		
		//获得所有的参数 参数封装到一个Map<String,String[]>
		//Map 接口中键和值一一映射. 可以通过键来获取值。
		Map<String,String[]> parameterMap=request.getParameterMap();
		for(Map.Entry<String, String[]> entry:parameterMap.entrySet()) {
			System.out.println(entry.getKey());
			for(String str: entry.getValue()) {
				System.out.println(str);
			}
			System.out.println("---------------------");
		}
	}
}
