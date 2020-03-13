package com.ds.digitalshop.controller;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;
import com.ds.digitalshop.util.SendMail;

/**
 * 
 * @author lwz
 * @date 2020年1月19
 */
@Controller
public class UserController {
	@Resource
	private UserService userService;
//用户注册
	@RequestMapping(value="AddUser", method = RequestMethod.POST)
	public String AddUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("email", email);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		if (username != "") {
			if (password != "") {
				if (email != "") {
					if (address != "") {
						if (phone != "") {
							User user = new User(username, password, email, address, phone);
							userService.addUser(user);
							if (user != null) {
								response.getWriter().println("<script>alert('注册成功！！！');window.location='login.jsp'</script>");
							}

						} else {
							request.setAttribute("addFail", "电话	不能为空！");
							request.getRequestDispatcher("register.jsp").forward(request, response);
						}

					} else {
						request.setAttribute("addFail", "地址不能为空！");
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}

				} else {
					request.setAttribute("addFail", "邮箱不能为空！");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("addFail", "密码不能为空！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("addFail", "用户名不能为空！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		return null;
	}
	//用户登录
	@RequestMapping(value="UserLogin", method = RequestMethod.POST)
	public String UserLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String flag = request.getParameter("isLogin");

		if ("y".equals(flag)) {
			// 创建两个Cookie对象
			Cookie nameCookie = new Cookie("username", name);
			// 设置Cookie的有效期为3天
			nameCookie.setMaxAge(60 * 60 * 24 * 3);
			Cookie pwdCookie = new Cookie("password", pwd);
			pwdCookie.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(nameCookie);
			response.addCookie(pwdCookie);
		}else{
			Cookie pwdCookie = new Cookie("password", pwd);
			pwdCookie.setMaxAge(0);
			response.addCookie(pwdCookie);
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.UserLogin(username, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("username", user.getUsername());
			request.getSession().setMaxInactiveInterval(3600);
			response.getWriter().println("<script> alert('登录成功！！');window.location='index.jsp'</script>");
		} else {
			response.getWriter().println("<script> alert('您输入的用户名或者密码错误，请重新登录');window.location='account.jsp'</script>");
		}
		return null;
	}
	//注销登录
	@RequestMapping(value="UserLogout", method = RequestMethod.GET)
	@SuppressWarnings("rawtypes")
	public String UserLogout(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//实现用户注销功能
		Enumeration em = request.getSession().getAttributeNames();
		 while(em.hasMoreElements()){
			 request.getSession().removeAttribute(em.nextElement().toString());
			 response.getWriter().println("<script> alert('注销成功');window.location='login.jsp'</script>");
		 }
		 return null;
	}
	//通过用户ID查看个人信息
	@RequestMapping(value="FindUserbyid", method = RequestMethod.GET)
	public String FindUserbyid(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int userid=Integer.parseInt(request.getParameter("userid"));
		User user=userService.findUserByid(userid);
		request.getSession().setAttribute("user", user);
		return "/userinformation.jsp";
	}
	//修改个人信息
	@RequestMapping(value="UpdateUser", method = RequestMethod.POST)
	public String UpdateUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int userid = Integer.parseInt(request.getParameter("userid"));
		String head_portrait = request.getParameter("head_portrait");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		if (username != "") {
			if (password != "") {
				if (email != "") {
					if (address != "") {
						if (phone != "") {
							User user = new User(userid, username, password, email, address, phone, head_portrait);
							userService.updateUser(user);
							request.getSession().setAttribute("user", user);
							response.getWriter().println("<script> alert('修改个人信息成功！！');window.location='userinformation.jsp'</script>");

						} else {
							request.setAttribute("addFail", "电话	不能为空！");
							request.getRequestDispatcher("userinformation.jsp").forward(request, response);
						}

					} else {
						request.setAttribute("addFail", "地址不能为空！");
						request.getRequestDispatcher("userinformation.jsp").forward(request, response);
					}

				} else {
					request.setAttribute("addFail", "邮箱不能为空！");
					request.getRequestDispatcher("userinformation.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("addFail", "密码不能为空！");
				request.getRequestDispatcher("userinformation.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("addFail", "用户名不能为空！");
			request.getRequestDispatcher("userinformation.jsp").forward(request, response);
		}
		return null;
	}
	//上传头像
	@RequestMapping(value="UploadProfile_Picture", method = RequestMethod.POST)
	public String UploadProfile_Picture(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response)throws Exception,ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		int userid=user.getUserid();
		if (file.isEmpty()) {
			response.getWriter().println("<script> alert('文件内容为空，请重新选择文件！');window.location='userinformation.jsp'</script>");
			request.getSession().setAttribute("user", user);
			return null;
	    }else {
	    	String path = String.format("D:\\img");
			// 获取原文件名
			String fileName = file.getOriginalFilename();
			 // 创建文件实例
		    File filePath = new File(path, fileName);
		    String head_portrait=fileName;
		    file.transferTo(filePath);
		    userService.updatehead_portrait(head_portrait, userid);
		    user.setHead_portrait(head_portrait);
			request.getSession().setAttribute("user", user);
			return "/userinformation.jsp";
		}
	}
	//通过邮箱和账号名 找回密码
	@RequestMapping(value="FindUserPassword", method = RequestMethod.POST)
	public String FindUserPassword(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		User user = null;
		PrintWriter out = response.getWriter();
		//实例化一个发送邮件的对象
		SendMail mySendMail = new SendMail();
		//根据邮箱找到该用户信息
		user = userService.findUserByUE(username, email);
		if(user!=null) {
			//设置收件人和消息内容
			mySendMail.sendMail(email, "数码商城系统提醒，您的密码为："+user.getPassword());
			out.println("<script>alert('密码已发送至邮箱，请注意查收');window.location.href='account.jsp'</script>");
			return null;
		} else {
			out.println("<script>alert('账号邮箱不匹配或该邮箱尚未注册！请重新输入');window.location.href='findpassword.jsp'</script>");
			return null;
		}
		
	}
	//用户查看自己的收藏
	@RequestMapping(value="MyFoavorites", method = RequestMethod.GET)
	public String MyFoavorites(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user1=(User)request.getSession().getAttribute("user");
		int userid=user1.getUserid();
		User user=userService.findUserByid(userid);
		request.setAttribute("user", user);
		return "/myfavorites.jsp";
	}
	//移除收藏
	@RequestMapping(value="RemoveCollect", method = RequestMethod.GET)
	public String RemoveCollect(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int cid = Integer.parseInt(request.getParameter("cid"));
		userService.removeUserCollectbycid(cid);
		return "/MyFoavorites";
	}
	//用户查看自己的订单
	@RequestMapping(value="MyOrder", method = RequestMethod.GET)
	public String MyOrder(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user1=(User)request.getSession().getAttribute("user");
		int userid=user1.getUserid();
		int pagenum = 1;
		
		if (request.getParameter("pagenum")==null) {
			if (request.getParameter("nowpage")==null) {
				pagenum = 1;
			}else{
				String page = request.getParameter("nowpage");
				pagenum = Integer.valueOf(page);
			}
		}else {
			String page = request.getParameter("pagenum");
			pagenum = Integer.valueOf(page);
		}
		
		request.setAttribute("orderlist",userService.OrderPage(pagenum, userid));
		return "/myorder.jsp";
	}
	//查看详细订单
	@RequestMapping(value="Order_detail", method = RequestMethod.GET)
	public String Order_detail(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		User user1=userService.findUserByid(user.getUserid());
		Set<Order> orders = user1.getOrders();
		for(Order order : orders){
			if (order.getOrderid()==Integer.valueOf(request.getParameter("orderid"))) {
				request.setAttribute("order", order);
			}
		}
		return "/myorder_detail.jsp";
	}
	//注册检查时是否有相同用户名
	@RequestMapping(value="CheckUsername", method = RequestMethod.GET)
	public String CheckUsername(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("username");

        String url = "jdbc:mysql://localhost:3306/digitalshop?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        OutputStream os = response.getOutputStream();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);
            String sql = "select username from user where username=? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();

            int status = -1;
            
            if(rs.next()) {
                System.out.println("用户名"+name+"已存在");
                status=0;
                String message = "{\"status\":"+status+"}";
                os.write(message.getBytes("UTF-8"));
                os.close();
                
            }
            
            System.out.println(name+"用户名不存在");
            String message = "{\"status\":"+status+"}";
            os.write(message.getBytes("UTF-8"));
            os.close();

        } catch (Exception e) {
            e.printStackTrace();

            String message = "系统异常";
            os.write(message.getBytes("UTF-8"));
            os.close();
        } finally {
            if(rs!=null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pst!=null) {
                try {
                    pst.close();
                    pst = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		return null;
	}
}
