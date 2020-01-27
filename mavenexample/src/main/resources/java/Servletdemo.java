package java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletdemo
 */
public class Servletdemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servletdemo() {
        // TODO Auto-generated constructor stub
    }
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession();
   try (PrintWriter out = response.getWriter()) {
       /* TODO output your page here. You may use following sample code. */
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Servlet insert</title>");            
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>Servlet insert at " + request.getContextPath() + "</h1>");
        String username=(String)session.getAttribute("username");
        out.println("<center><h2>"+"HELLO "+username+"!</h2></center>");
   if(username==null){
   	response.sendRedirect("index.html");
   }
     String id=request.getParameter("id");    
     String name=request.getParameter("name");
     String price=request.getParameter("price");
     String availability=request.getParameter("availability");
     String quantity=request.getParameter("quantity");
   try
   {
  Class.forName("com.mysql.jdbc.Driver");
  String url="jdbc:mysql://127.0.0.1:3306/productdb";
  String uname="root";
  String password="root";
  String query="insert into productdetails(product_id,name,price,availability,quantity) values('"+id+"','"+name+"','"+price+"','"+availability+"','"+quantity+"')";
  Connection conn=DriverManager.getConnection(url, uname, password);
  Statement stmt=conn.createStatement();
  int result=stmt.executeUpdate(query);
  
out.println(result);

if(result>=0)
  out.println("Data is successfully inserted!");
else
  out.println(" insertion failed!");
}    
catch(Exception e)
{
out.print(e);
e.printStackTrace();
}
       out.println("</body>");
       out.println("</html>");

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
