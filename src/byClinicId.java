

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


@WebServlet("/byClinicId")
public class byClinicId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection con;
       private Statement st;
    
    public byClinicId() {
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
		String id=request.getParameter("id");
		int count=0;
		int id1=Integer.parseInt(id);
		PrintWriter w=response.getWriter();
		try {
			ResultSet rs = st.executeQuery("select * from appointmentinfo where clinicid='"+id1+"'");
			while(rs.next()) {
				count++;
				
			}
			w.println("<h2>The numbers of appointments of clinic id- "+id1+" is "+count+"</h2>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
