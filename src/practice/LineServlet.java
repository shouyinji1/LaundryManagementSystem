package practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LineServlet
 */
@WebServlet("/LineServlet")
public class LineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#Hwww.ttpServlet()
     */
    public LineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 获得请求方式
		String method=request.getMethod();	//用于获得客户端向服务器端传送数据的方法，如get、post
		System.out.println("method:"+method);
		
		// 2. 获得请求的资源相关的内容
		String requestURI=request.getRequestURI();
		//当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
		StringBuffer requestURL=request.getRequestURL();
		System.out.println("uri:"+requestURI);
		System.out.println("url:"+requestURL);
		
		//获得Web应用的名称
		String contextPath=request.getContextPath();
		System.out.println("Web应用："+contextPath);
		
		//地址后的参数的字符串
		String queryString=request.getQueryString();
		System.out.println(queryString);
		
		// 3. 获得客户机的信息---获得访问者IP地址
		String remoteAddr=request.getRemoteAddr();
		System.out.println("IP:"+remoteAddr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
