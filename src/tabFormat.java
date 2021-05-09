

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tabFormat")
public class tabFormat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Connection con;
     private Statement st;
    
    public tabFormat() {
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
			ResultSet rs = st.executeQuery("select proceduretype,clinicname,prov,year(proceduredate),month(proceduredate),amount from transactioninfo, clinicInfo");
			w.println("<table border=1>");
			w.println("<tr>");
			w.println("<th>");
			w.println("Procedure types");
			w.println("</th>");
			w.println("<th>");
			w.println("Clinic Name");
			w.println("</th>");
			w.println("<th>");
			w.println("provider");
			w.println("</th>");
			w.println("<th>");
			w.println("Year");
			w.println("</th>");
			w.println("<th>");
			w.println("Month");
			w.println("</th>");
			w.println("<th>");
			w.println("Amounts");
			w.println("</th>");
			w.println("</tr>");
			while(rs.next()) {
				w.println("<tr>");
				w.println("<td>");
				w.println(rs.getString(1));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getString(2));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getInt(3));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getInt(4));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getInt(5));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getInt(6));
				w.println("</td>");
				w.println("</tr>");
			}
			w.println("</table>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
