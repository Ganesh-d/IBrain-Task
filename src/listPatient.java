

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

@WebServlet("/listPatient")
public class listPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    private Statement st;
    
    public listPatient() {
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
			ResultSet rs = st.executeQuery("select * from patientinfo where patId NOT IN(select patId from appointmentinfo)");
			
			w.println("<table border=1>");
			w.println("<tr>");
			w.println("<th>");
			w.println("Patient Id");
			w.println("</th>");
			w.println("<th>");
			w.println("Practice Id");
			w.println("</th>");
			w.println("<th>");
			w.println("Last Name");
			w.println("</th>");
			w.println("<th>");
			w.println("First Name");
			w.println("</th>");
			w.println("<th>");
			w.println("City");
			w.println("</th>");
			w.println("<th>");
			w.println("State");
			w.println("</th>");
			w.println("<th>");
			w.println("Gender");
			w.println("</th>");
			w.println("<th>");
			w.println("Birth Date");
			w.println("</th>");
			w.println("</tr>");
			while(rs.next()) {
				w.println("<tr>");
				w.println("<td>");
				w.println(rs.getInt(1));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getInt(2));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getString(3));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getString(4));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getString(5));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getString(6));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getString(7));
				w.println("</td>");
				w.println("<td>");
				w.println(rs.getDate(9));
				w.println("</td>");
				w.println("</tr>");
			}
			w.println("</table>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
