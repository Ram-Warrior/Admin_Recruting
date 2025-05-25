package admin_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class User_page extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Uname=req.getParameter("n");
		HttpSession s1=req.getSession();
		if(Uname.equals("user")) {
			Connection con=null;
			PreparedStatement ps=null;
			Statement st=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&&password=root");
					st=con.createStatement();
					PrintWriter details=resp.getWriter();
					ResultSet rs=st.executeQuery("select * from admin");
					details.println("<html><body><table border='5' cellpadding='20' cellspacing='10' align='center'>"
							+ "<tr><thead><th>EmpId</th><th>EmpName</th><th>Experience</th><th>OnboardingStatus</th><th>RecrutingTeam</th>"
							+ "<th>Manager</th><th>Role</th><th>Email</th><th>DOB</th><th>DOJ</th></thead></tr>");
					while (rs.next()) {
					int id=rs.getInt(1);
					String name=rs.getString(2);
					double exp=rs.getDouble(3);
					String sta=rs.getString(4);
					String rt=rs.getString(5);
					String m=rs.getString(6);
					String r=rs.getString(7);
					String em=rs.getString(8);
					String dob=rs.getString(9);
					String doj=rs.getString(10);
					details.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+exp+"</td><td>"+sta+"</td><td>"+rt+"</td><td>"+m+"</td><td>"+r+"</td><td>"+em+"</td><td>"+dob+"</td> <td>"+doj+"</td>"
							+ "</tr>");	
					}
					details.println("</tbody></table></body></html>");	
					
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else {
			PrintWriter p=resp.getWriter();
			p.println("<html><body> <h3 style='color: red;'>Account Doesn't Exist<h3></body></html>");
			RequestDispatcher r=req.getRequestDispatcher("admin.html");
			r.include(req, resp);
		}
	}
	
}
