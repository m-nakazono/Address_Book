package src.Address;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Address;

@WebServlet("/Registration")
public class INSERT2 extends HttpServlet{
 private static final long serialVersionUID = 1L;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

 //サーブレットクラスの動作を決定する「action」の値をリクエストパラメータから取得
   String action = request.getParameter("action");

   if(!"done".equals(action)) {
   // 「name」をリクエストされたときの処理
       RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/Registration");
       dispatcher.forward(request, response);
     } else {
     // 「address」をリクエストされたときの処理
       RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/Registration");
       dispatcher.forward(request, response);
     }
     // 「map」をリクエストされたときの処理
      RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/Registration");
      dispatcher.forward(request, response);
     }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
 //リクエストの文字コードを指定
   response.setContentType("text/html; charset=UTF-8");
   request.setCharacterEncoding("UTF-8");

 //サーブレットクラスの動作を決定する「action」の値をリクエストパラメータから取得
   String action = request.getParameter("action");


   if(!"done".equals(action)) {
    // 「確認」をリクエストされたときの処理
	   String name = request.getParameter("mine");
	   String add = request.getParameter("map");
	   String tel = request.getParameter("number");

	  //入力チェック
	  //HashMap<String,String> errors = new HashMap<>();
	   List<String> errors = new ArrayList<String>();

	   if((name == null || name.trim().length() == 0))
		   errors.add(" * 名前を入力してください。");
       if((add == null || add.trim().length() == 0))
    	   errors.add(" * 住所を入力してください。");
       if((tel == null || tel.trim().length() == 0))
		   errors.add(" * 電話番号を入力してください。");

	  //登録するユーザー情報を生成
	    Address Registration = new Address();

	  //登録ユーザーを保存
        HttpSession session = request.getSession();
        session.setAttribute("Registration", Registration);

	    if(errors.isEmpty() == false){
		  //errorsが空でない時（入力されていないのでエラーメッセージがある時）
	      //入力エラーがある場合は入力画面に戻す
	        request.setAttribute("errors", errors);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/Registration");
	        dispatcher.forward(request, response);
        } else {
	      //エラーがない場合は確認画面にフォワードする
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/Result");
	        dispatcher.forward(request, response);
        }

        } else {
       //登録確認画面から「登録」をリクエストされたときの処理

       //セッションスコープに保存された登録ユーザーを取得
         HttpSession session = request.getSession();
         Address Result = (Address) session.getAttribute("Result");

       //不要となったセッションスコープ内のインスタンスを削除
         session.removeAttribute("Registration");

       //登録後のリダイレクト
         response.sendRedirect(request.getServletContext().getContextPath() + "/Registration");
	    }
	  }
    }
