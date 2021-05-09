

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delApp")
public class delApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    private Statement st;   
    
    public delApp() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital","root","test");
			st=con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		try {
			int executeUpdate = st.executeUpdate("delete from appointmentinfo where amount<=50");
			w.println("deleted successfully!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
