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

public class New_user extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ok=req.getParameter("ok");
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
			 PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?,?,?)");
			 ps.setInt(1,id);
			 ps.setString(2,name);
			 ps.setDouble(3,ex);
			 ps.setString(4,ons);
			 ps.setString(5,rt);
			 ps.setString(6, mn);
			 ps.setString(7,rl);
			 ps.setString(8, em);
			 ps.setString(9, dob);
			 ps.setString(10, doj);
			 ps.executeUpdate();	
			 resp.sendRedirect("admin.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
