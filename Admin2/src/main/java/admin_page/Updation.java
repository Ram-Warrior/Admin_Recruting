package admin_page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Updation  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("n");
		double ex=Double.parseDouble(req.getParameter("ex"));
		String ons=req.getParameter("ons");
		String rt=req.getParameter("rt");
		String mn=req.getParameter("mn");
		String rl=req.getParameter("rl");
		String em=req.getParameter("em");
		String dob=req.getParameter("dob");
		String doj=req.getParameter("doj");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&&password=root");
			 PreparedStatement ps=con.prepareStatement("update admin set EmpName=?,Experience=?,OnboardingStatus=?,RecrutingTeam=?,Manager=?,Role=?,Email=?,DOB=?,DOJ=? where EmpId=?");
			 ps.setString(1,name);
			 ps.setDouble(2,ex);
			 ps.setString(3,ons);
			 ps.setString(4,rt);
			 ps.setString(5, mn);
			 ps.setString(6,rl);
			 ps.setString(7, em);
			 ps.setString(8, dob);
			 ps.setString(9, doj);
			 ps.setInt(10,id);
			 ps.executeUpdate();	
			 resp.sendRedirect("admin.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
