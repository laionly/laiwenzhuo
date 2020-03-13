package com.ds.digitalshop.servlet.user;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUsernameServlet
 */
@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
