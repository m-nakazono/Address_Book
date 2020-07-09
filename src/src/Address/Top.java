package src.Address;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Top extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
		     throws IOException,ServletException{
	   response.setContentType("text/html; charset=UTF-8");
	   request.setCharacterEncoding("UTF-8");
	   String search = request.getParameter("search"); //前画面で入力した値(住所)
	   if(search == null) {
		   search = "";
	   }
	   PrintWriter out = response.getWriter();
	     out.println("<html>");
	     out.println("<head>");
	     out.println("<title>Add_Top</title>");
	     out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/Address/media.css\"></link>");
	     out.println("</head>");
	     out.println("<body>");
         out.println("<h3>住所録管理システム：住所録一覧</h3>");
         out.println("<br>");
         out.println("<Registration.jsp><input type=\"submit\" value=\"新規登録\" style=\"width:10%; position:absolute; right:85%; top:60px;\"></form>");
         out.println("<form action=\" ./Search\" method=\"post\"><input type=\"text\" name=\"search\" style=\"width:15%; position: absolute; right:10%; top:63px\"><input type=\"submit\" value=\"検索\" style=\"width:7%; height:3.4%; position:absolute; left:89%; top:63px;\"></form>");
         out.println("</br>");
         out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"7\" align=\"center\">");
	     out.println("<tr>");
	     out.println("<th width=\"26\" style=\"top:630px;\">No</th>");
         out.println("<th width=\"108\" style=\"top:630px;\">名前</th>");
         out.println("<th width=\"341\" style=\"top:630px;\">住所</th>");
         out.println("<th width=\"141\" style=\"top:630px;\">電話番号</th>");
         out.println("<th width=\"109\" style=\"top:630px;\">カテゴリ</th>");
         out.println("<th width=\"81\" style=\"top:630px;\">&nbsp;</th>");
	     out.println("</tr>");
	     out.println("</table>");

	  try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    java.sql.Connection conn =
		    DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sep2019.1173-nakaono-H10.1210");

		    String sql = "select * from add_book";
		    PreparedStatement ps = null;
            System.out.println(search);
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, "%"+search+"%");
		    ResultSet resultSet = ps.executeQuery();

		    while(resultSet.next()) {
		    	   out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"7\" align=\"center\">");
		    	   out.println("<td width=\"26\" align=\"center\">"+resultSet.getInt("id") +"</td>");
		    	   out.println("<td width=\"108\" align=\"center\">"+resultSet.getString("name") +"</td>");
		    	   out.println("<td width=\"341\">"+resultSet.getString("address") +"</td>");
		           out.println("<td width=\"142\" align=\"center\">"+resultSet.getString("tel") +"</td>");
		           out.println("<td width=\"109\" align=\"center\">"+resultSet.getString("categoryid") +"</td>");
		           out.println("<td align=\"center\" bgcolor=\"#c0c0c0\"><a href=\"Edit?id="+resultSet.getInt("id") +"\" >編集</a></td>");
		           out.println("<td align=\"center\" bgcolor=\"#c0c0c0\"><a href=\"DeleteData?id="+resultSet.getInt("id") +"\">削除</a></td>");
		    }
	        }catch(Exception e) {
	           out.println(e.getMessage());
	        }

           out.println("<Registration.jsp><input type=\"submit\" value=\"新規登録\" style=\"width:10%; position:absolute; right:85%; top:540px;\"></form>");
	       out.println("</body>");
           out.println("</html>");

	}

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException{
	     response.setContentType("text/html; charset=UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     PrintWriter out = response.getWriter();
	       out.println("<html>");
	       out.println("<head>");
	       out.println("<title>Add_Top</title>");
	       out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/Address/media.css\"></link>");
	       out.println("</head>");
	       out.println("<body>");
           out.println("<h3>住所録管理システム：住所録一覧</h3>");
           out.println("<br>");
           out.println("<form action=\" ./Registration\" method=\"post\"><input type=\"submit\" value=\"新規登録\" style=\"width:10%; position:absolute; right:85%; top:60px;\"></form>");
           out.println("<form action=\" ./Search\" method=\"post\"><input type=\"text\" name=\"search\" style=\"width:15%; position: absolute; right:10%; top:63px\"><input type=\"submit\" value=\"検索\" style=\"width:7%; height:3.4%; position:absolute; left:89%; top:63px;\"></form>");
           out.println("</br>");
           out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"7\" align=\"center\">");
	       out.println("<tr>");
		   out.println("<th width=\"26\" style=\"top:630px;\">No</th>");
	       out.println("<th width=\"108\" style=\"top:630px;\">名前</th>");
	       out.println("<th width=\"341\" style=\"top:630px;\">住所</th>");
	       out.println("<th width=\"141\" style=\"top:630px;\">電話番号</th>");
	       out.println("<th width=\"109\" style=\"top:630px;\">カテゴリ</th>");
	       out.println("<th width=\"81\" style=\"top:630px;\">&nbsp;</th>");
	       out.println("</tr>");
	       out.println("</table>");


	  try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    java.sql.Connection conn =
		    DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sep2019.1173-nakaono-H10.1210");

		    String sql = "select * from add_book";
		    Statement statement = conn.createStatement(30, 0, 0);
		    ResultSet resultSet = statement.executeQuery(sql);
		    while(resultSet.next()) {
		    	   out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"7\" align=\"center\">");
		    	   out.println("<td width=\"26\" align=\"center\">"+resultSet.getInt("id") +"</td>");
		    	   out.println("<td width=\"108\" align=\"center\">"+resultSet.getString("name") +"</td>");
		    	   out.println("<td width=\"341\">"+resultSet.getString("address") +"</td>");
		           out.println("<td width=\"142\" align=\"center\">"+resultSet.getString("tel") +"</td>");
		           out.println("<td width=\"109\" align=\"center\">"+resultSet.getString("categoryid") +"</td>");
		           out.println("<td align=\"center\" bgcolor=\"#c0c0c0\"><a href=\"Edit?id="+resultSet.getInt("id") +"\" >編集</a></td>");
		           out.println("<td align=\"center\" bgcolor=\"#c0c0c0\"><a href=\"DeleteData?id="+resultSet.getInt("id") +"\">削除</a></td>");
		    }
	        }catch(Exception e) {
	        	out.println(e.getMessage());
	        }

           out.println("<form action=\" ./Registration\" method=\"post\"><input type=\"submit\" value=\"新規登録\" style=\"width:10%; position:absolute; right:85%; top:540px;\"></form>");
	       out.println("</body>");
           out.println("</html>");
	}
  }
