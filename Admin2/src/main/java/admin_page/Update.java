package admin_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Update extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("n"));
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&&password=root");
			ps=con.prepareStatement("Select * from admin where EmpId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==id) {				
				String name=rs.getString(2);
				Double ex=rs.getDouble(3);
				String ons=rs.getString(4);
				String rt=rs.getString(5);
				String mn=rs.getString(6);
				String rl=rs.getString(7);
				String em=rs.getString(8);
				String dob=rs.getString(9);
				String doj=rs.getString(10);	
		 PrintWriter r1=resp.getWriter();
				r1.println("<html><body> <form action='up' method='post'>Employee Id : <input type='text' value="+id+" name='id' readonly>  <br>"
						+ "name : <input type='text' value="+name+" readonly='readonly' name='n'> <br>"
						+ "Experince : <input type='text' value="+ex+" name='ex' > <br>"
						+ "Onboardind Status : <input type='text' value="+ons+" name='ons'> <br>"
						+ "Recruting Team  : <input type='text' value="+rt+" name='rt'> <br>"
						+ "Manager Name : <input type='text' value="+mn+" name='mn'> <br>"
						+ "Role : <input type='text' value="+rl+"  name='rl'> <br>"
						+ "Email : <input type='text' value="+em+" name='em'> <br>"
						+ "DOB : <input type='text' value="+dob+" readonly='readonly' name='dob'> <br>"
						+ "DOJ : <input type='text' value="+doj+" readonly='readonly' name='doj'> <br>"
								+ "<button>update</button>"
								+ "</form></body></html>");
				}
				
			}
			ps.executeUpdate();
			
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

