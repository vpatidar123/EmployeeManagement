

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class EmployeeDetails
 */
@WebServlet("/PaySlip")
public class PaySlip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaySlip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String month = request.getParameter("Month");
		int year = Integer.parseInt(request.getParameter("Year"));
		try {
			int noOfWorkingDays = getNoOfWorkingDays((int)session.getAttribute("empId"),year,month);
			session.setAttribute("noOfWorkingDays", noOfWorkingDays);
			if(noOfWorkingDays == -1) {
				session.setAttribute("msg","Detail not available in database");
				response.sendRedirect("Time Sheet.jsp");
			}
			else {
				int salary = (int)session.getAttribute("salary");
			    float deduction = 2000 * ((float)noOfWorkingDays / 31);
				float basic = (float)((salary * 0.5)*((float)noOfWorkingDays / 31)); 
				float da = (float)(basic * 0.3);
				float hra = (float)((basic * 0.4) + da);
				float totalSalary = basic + da + hra;
				session.setAttribute("basic", basic);
				session.setAttribute("dearnessAllowance", da);
				session.setAttribute("houseRentAllowance", hra);
				session.setAttribute("deduction", deduction);
				session.setAttribute("totalSalary", totalSalary - deduction);
			
				response.sendRedirect("PaySlip.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	public int getNoOfWorkingDays(int empNo, int year, String month) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		
		PreparedStatement p = connect.prepareStatement("select no_of_working_days from TimeSheet where EmpNo = ? and month = ? and year = ?");
		p.setInt(1, empNo);
		p.setString(2, month);
		p.setInt(3, year);
		
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return r.getInt(1);
		
		p.close();
		connect.close();
		return -1;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/NPCI","npci","password");
		
		
		
		
		
	}

	
}