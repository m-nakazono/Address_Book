package src.Address;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class INSERT4 extends HttpServlet {
  private static final long serialVersionUID = 3L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws IOException,ServletException{
	 response.setContentType("text/html; charset=UTF-8");
	 PrintWriter out = response.getWriter();
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<title>Add_INSERT</title>");
	  out.println("</head>");
	  out.println("<body>");
	  out.println("<h3>住所録管理システム：住所録登録</h3>");
	  out.println("</body>");
	  out.println("</html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws IOException,ServletException{
	 response.setContentType("text/html; charset=UTF-8");
	 PrintWriter out = response.getWriter();
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<title>Add_INSERT</title>");
	  out.println("</head>");
	  out.println("<body>");
	  out.println("<h3>住所録管理システム：住所録登録</h3>");

	 //変数定義
	   Connection conn = null;
	   PreparedStatement ps = null;

	 //DB接続情報を設定する ログインID
	   String path = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";  //接続パス
	   String id = "root"; // ログインID
	   String pw = "sep2019.1173-nakaono-H10.1210"; //ログインパスワード

	 //SQL文を定義する
	   request.setCharacterEncoding("UTF-8");
	   String mine = request.getParameter("mine"); //前画面で入力した値(名前)
	   String map = request.getParameter("map"); //前画面で入力した値(住所)
	   String number = request.getParameter("number"); //前画面で入力した値(電話番号)
	   String sql = "INSERT INTO add_book (name,address,tel) values(?,?,?)";

try {
	  //JDBCドライバをロードする
	    Class.forName("com.mysql.cj.jdbc.Driver"); //JDBCドライバクラス

	  //DBへのコネクションを作成する
	    conn = DriverManager.getConnection(path,id,pw);

	  //実行するSQL文とパラメータを指定する
	    ps = conn.prepareStatement(sql);
	    ps.setString(1, mine);
	    ps.setString(2, map);
	    ps.setString(3, number);

	  //INSERT文を実行する
	    int i = ps.executeUpdate(sql);

	  //処理件数を表示する
	    System.out.println("名前*：" +i);
	    System.out.println("住所*：" +i);
	    System.out.println("電話番号：" +i);
	    System.out.println("カテゴリ：" +i);
	    out.println("名前*：" +i);
	    out.println("住所*：" +i);
	    out.println("電話番号：" +i);
	    out.println("カテゴリ：" +i);

	  //コミット
	    conn.commit();
     } catch (Exception ex) {
      //例外発生時の処理
try {
	   conn.rollback();
	 } catch (SQLException e) {
      // TODO 自動生成された catch ブロック
	   e.printStackTrace();
	 }//ロールバックする
       ex.printStackTrace();  //エラー内容をコンソールに出力する
     } finally {
     //クローズ処理
       if (ps != null)
try {
	   ps.close();
	 } catch (SQLException e) {
	 // TODO 自動生成された catch ブロック
	   e.printStackTrace();
	 }
       if (conn != null)
try {
       conn.close();
     } catch (SQLException e) {
     // TODO 自動生成された catch ブロック
	   e.printStackTrace();
	}
}
     out.println("</body>");
     out.println("</html>");
}
}

