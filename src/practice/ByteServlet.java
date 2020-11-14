package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ByteServlet
 */
@WebServlet("/ByteServlet")
public class ByteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置文件的类型
		response.setContentType(this.getServletContext().getMimeType("download/test.txt"));
		
		//告诉客户端（浏览器）以下载的方式打开文件，设置Context-Dispostion头，并设置文件名字
		response.setHeader("Content-Dispostion", "attachment;filename=\"file.txt\"");
		
		// 使用response获得字节输出流
		ServletOutputStream out = response.getOutputStream();
		
		//获得服务器上的图片，此时浏览器会直接解析并显示
		String realPath=this.getServletContext().getRealPath("download/test.txt");
		
		InputStream in=new FileInputStream(realPath);
		
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=in.read(buffer))>0) {
			out.write(buffer,0,len);
		}
		in.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
