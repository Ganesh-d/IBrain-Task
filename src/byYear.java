

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


@WebServlet("/byYear")
public class byYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    private Statement st;
    
    public byYear() {
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
		String year = request.getParameter("year");
		int year1=Integer.parseInt(year);
		int count=0;
		PrintWriter w=response.getWriter();
		
		try {
			ResultSet rs = st.executeQuery("select * from appointmentinfo where year(apptdate)='"+year1+"'");
			while(rs.next()) {
				count++;
			}
			w.println("<h2>");
			w.println("The numbers of appointments of year - "+year1+" is "+count);
			w.println("</h2>");
		} catch (Exception e) {
			System.out.println(e);
		}
	} 

}
