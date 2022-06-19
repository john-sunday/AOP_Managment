package pills.es.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrudConnection
 */
@WebServlet("/CrudConnection")
public class CrudConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Método que vamos a usar.
	 */
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response) 
								throws ServletException, IOException {		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String jdbcUrl = "jdbc:mysql://localhost:3306/crud_order_managment?useSSL=false";
		String user = "root";
		String pass = "root";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			// Print in Web Browser.
			PrintWriter out = response.getWriter();
			out.print("DB name: " + jdbcUrl + "\n");
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.print("CONNECTED !!!");
			myConn.close();
		}catch(Exception e) {
			e.printStackTrace();
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
