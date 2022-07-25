

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeDetails
 */
@WebServlet("/Details")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			Employee e = getEmployeeDetails(email);
			Department d = getEmployeeDepartment(e.getDeptNo());
			session.setAttribute("empName", e.geteName());
			session.setAttribute("empId", e.getEmpNo());
			session.setAttribute("departmentName", d.getDepartmentName());
			session.setAttribute("salary", e.getSalary());
			session.setAttribute("hireDate", e.getHireDate());
			session.setAttribute("msg", "");
			response.sendRedirect("Time Sheet.jsp");
			
			out.print("<br><a href='Logout'>Logout</a>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	
	}
	
	

	private Employee getEmployeeDetails(String email) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select * from Employee where EmpNo = (select EmpNo from EmployeeLoginCredentials where emailID = ?);");
		p.setString(1, email);
		
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6),r.getString(7),r.getInt(8));
		
		return null;
	}
	
	private Department getEmployeeDepartment(int deptNo) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select * from Department where DeptNo = ?;");
		p.setInt(1, deptNo);		
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return new Department(r.getInt(1),r.getString(2),r.getString(3));
		
		return null;
	} 
	

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/NPCI","npci","password");
		
		
		
		
		
	}

	
}