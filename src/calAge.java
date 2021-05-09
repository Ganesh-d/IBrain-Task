

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Stack;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calAge")
public class calAge extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    private Statement st;
   
    public calAge() {
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
		int age,element1,patId,element2;
		PrintWriter w=response.getWriter();
		Stack<Integer> stack1=new Stack<Integer>();
		Stack<Integer> stack2=new Stack<Integer>();
		try {
			//firstly find the age of patient
			ResultSet rs = st.executeQuery("select patId,year(CURDATE())-year(birthdate) as age from patientinfo");
			while(rs.next()) {
				patId=rs.getInt(1);
				age=rs.getInt(2);
				//store age into stack 
				stack1.push(age);
				stack2.push(patId);
				
			}
			for(int i=0;i<stack1.size();i++) {
				element1=stack1.get(i);//age
				element2=stack2.get(i);//id
				//here update age of patients
				st.executeUpdate("update patientinfo set age='"+element1+"' where patId='"+element2+"'");
				//here we update patient age group
				
				if(element1<18) {
					st.executeUpdate("update patientinfo set patientagegroup='Minor' where patId='"+element2+"'");
				}else {
					st.executeUpdate("update patientinfo set patientagegroup='Adult' where patId='"+element2+"'");
				}
			}
			w.println("<h2>Detail of patient is updated successfully</h2>");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
