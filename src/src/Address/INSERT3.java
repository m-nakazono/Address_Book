package src.Address;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class INSERT3 extends HttpServlet {
 private static final long serialVersionUID = 1L;
  protected void doGet(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
   response.setContentType("text/html; charset=UTF-8");
   request.setCharacterEncoding("UTF-8");
   PrintWriter out = response.getWriter();
   out.println("<html>");
   out.println("<head>");
   out.println("<title>Add_INSERT</title>");
   out.println("</head>");
   out.println("<body>");
   out.println("<h3>住所録管理システム：住所録登録</h3>");
   out.println("<form action=\" ./InsertDB\" method=\"post\"><input type=\"submit\"value=\"\"></form>");
   out.println("</body>");
   out.println("</html>");
  }

 protected void doPost(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
   response.setContentType("text/html; charset=UTF-8");
   request.setCharacterEncoding("UTF-8");
   PrintWriter out = response.getWriter();
   PreparedStatement ps = null;
   String name = request.getParameter("mine");
   String add = request.getParameter("map");
   String tel = request.getParameter("number");

try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 java.sql.Connection conn =
	 DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sep2019.1173-nakaono-H10.1210");
	 String sql = "INSERT INTO add_book (name,address,tel) values(?,?,?);";
     Statement statement = conn.createStatement(30, 0, 0);
     ps = conn.prepareStatement(sql);
     ps.setString(1, name);
	 ps.setString(2, add);
	 ps.setString(3, tel);
     int i = ps.executeUpdate();
     }catch(Exception e) {
   	  out.println(e.getMessage());
     }

   out.println("<html>");
   out.println("<head>");
   out.println("<title>Add_INSERT</title>");
   out.println("</head>");
   out.println("<body>");
   out.println("<h3>住所録管理システム：住所録登録</h3>");
   out.println("名前*："+name+"<br>住所*："+add+"<br>電話番号："+tel+"<br>カテゴリ：<br>"+"<form action=\" ./Search\" method=\"post\"><input type=\"hidden\" name=\"mine\" value=\""+name+"\"><input type=\"hidden\" name=\"map\" value=\""+add+"\"><input type=\"hidden\" name=\"number\" value=\""+tel+"\"><input type=\"submit\" value=\"登録\" style=\"width:7%; position:absolute; left:7%; top:143px\"></form>");
   out.println("<a href=\"Registration\"><input type=\"submit\" value=\"戻る\" style=\"width:7%; position:absolute; left:18%; top:143px;\"></a><br>");
   out.println("</body>");
   out.println("</html>");
  }
 }

