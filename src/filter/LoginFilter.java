package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

/**
 * Servlet Filter implementation class LoginFilter
 * 登录拦截器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("登录拦截器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String servletPath = req.getServletPath();
		//如果是访问登录页面则直接放行
    	if(servletPath.contains("login.html")
    			|| servletPath.contains("register.html")
    			|| servletPath.contains("loginServlet") 
    			|| servletPath.contains("registerServlet") 
    			||servletPath.contains(".js")
    			||servletPath.contains(".css")) {
    		chain.doFilter(req, resp);
		}else {
			User user = (User)req.getSession().getAttribute("user");
			//如果用户没登陆，重定向到登录页面
			if(user==null) {
				//如果用户没登陆，跳转到登录页面
				request.getRequestDispatcher("login.html").forward(request, response);
			}else {
				chain.doFilter(req, resp);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("登录拦截器初始化");
	}

}
