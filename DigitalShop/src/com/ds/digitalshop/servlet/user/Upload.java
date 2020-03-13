package com.ds.digitalshop.servlet.user;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext sc=getServletContext();
		sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		UserService us=(UserService)ac.getBean("uservice");
		User user = (User) request.getSession().getAttribute("user");
		int userid=user.getUserid();
		try {
            // 配置上传参数
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            // 迭代表单数据
            for (FileItem item : formItems) {
                // 处理不在表单中的字段
            	if(item.getSize()==0){
            		request.getSession().setAttribute("user", user);
            		response.getWriter().println("<script> alert('文件内容为空，请重新选择文件！');window.location='userinformation.jsp'</script>");
            	}else {
            		if (!item.isFormField()) {
                        String fileName = item.getName();
                        //定义上传文件的存放路径
//                        String path = request.getServletContext().getRealPath("D:/img");
                        //定义上传文件的完整路径
                        //"%s/%s",
                        String filePath = String.format("%s/%s","D:\\img",fileName);
                        System.out.println(filePath);
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        String head_portrait=item.getName();
                        us.updatehead_portrait(head_portrait, userid);  
                        // 保存文件到硬盘
                        item.write(storeFile);
                        user.setHead_portrait(head_portrait);
                        request.getSession().setAttribute("user", user);
                        request.getRequestDispatcher("userinformation.jsp").forward(request, response);
                    }
				}
                
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }

	}

}
