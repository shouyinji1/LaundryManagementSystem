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
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 * 乱码拦截器
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("乱码过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		MyRequest myRequest = new MyRequest((HttpServletRequest)request);
		//过滤器放行
		chain.doFilter(myRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("乱码过滤器初始化");
	}

	public class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		/**
		 * 构造函数
		 * @param request
		 */
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		
		/**
		 * 重写getParameter（用于获取表单参数）
		 */
		@Override
		public String getParameter(String name) {
			String value = request.getParameter(name);
			if(value!=null) {
				try {
					value = new String(value.getBytes("utf-8"),"utf-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return value;
		}
	}
}
