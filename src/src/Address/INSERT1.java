package src.Address;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class INSERT1 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public void ServletController(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

	   response.setContentType("text/html; charset=UTF-8");
	   PrintWriter out = response.getWriter();
	   out.println("<html>");
       out.println("<head>");
       out.println("<title>Add_INSERT</title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<form action=\" /InsertDB\" method=\"post\"><h3>住所録管理システム：住所録登録</h3><input type=\"text\" name=\"data\"><input type=\"submit\" value=\"\"></form>");
       out.println("</body>");
       out.println("</html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException{
	            doGet(request, response);
        }
   public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws IOException,ServletException{
	     response.setContentType("text/html; charset=UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     PrintWriter out = response.getWriter();
	       out.println("<html>");
	       out.println("<head>");
	       out.println("<title>Add_INSERT</title>");
	       out.println("</head>");
	       out.println("<body>");
           out.println("<h3>住所録管理システム：住所録登録</h3>");
	       out.println("<form action=\" ./Checktest\" method=\"post\">名前*：<input type=\"text\" name=\"mine\" style=\"width:15%; position:absolute; left:8%; top:59px;\"><br>住所*：<input type=\"text\" name=\"map\" style=\"width:30%; position:absolute; left:8%; top:78px;\"><br>電話番号：<input type=\"text\" name=\"number\" style=\"width:15%; position:absolute; left:8%; top:98px;\"><br>カテゴリ：<select name=\"cate\" style=\"width:15%; position:absolute; left:8%; top:120px;\"></select><input type=\"submit\" value=\"確認\" style=\"width:7%; position:absolute; left:8%; top:160px;\"></form>");
	       out.println("<a href=\"Search\"><input type=\"submit\" value=\"戻る\" style=\"width:7%; position:absolute; left:19%; top:160px;\"></a><br>");
	       List<String> errors = (List<String>)request.getAttribute("errors");
           for(Iterator<String>itr = errors.iterator(); itr.hasNext();)
            { String error = itr.next();
           out.println("<ul><dd>");
           out.println(error);
           out.println("</ul></dd>"); }
	       out.println("</body>");
           out.println("</html>");
	}
}
