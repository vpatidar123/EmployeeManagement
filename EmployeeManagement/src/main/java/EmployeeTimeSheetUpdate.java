
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
@WebServlet("/TimeSheet")
public class EmployeeTimeSheetUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeTimeSheetUpdate() {
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
		int empId = (int)session.getAttribute("empId");
		int month = Integer.parseInt(request.getParameter("Month"));
		String hireDate = (String)session.getAttribute("hireDate");
		String[] date = hireDate.split("/");
		int noOfWorkingDays = Integer.parseInt(request.getParameter("No_of_working_days"));
		int year = Integer.parseInt(request.getParameter("YearTimeSheet"));
		
		try {
			if(year > 2022 || (month > 7 && year >= 2022) ){
				session.setAttribute("msg","enter valid date");
			}
			else if(Integer.parseInt(date[2]) > year || (Integer.parseInt(date[1]) < month && Integer.parseInt(date[2]) == year )) {
				session.setAttribute("msg", "hire date is invalid");
			}
			else if(updateTimeSheet(month, noOfWorkingDays, year, empId)) {
				session.setAttribute("msg", "details added in database");
			}
			else {
				session.setAttribute("msg", "details already present");
			}
			    response.sendRedirect("Time Sheet.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	private boolean updateTimeSheet(int month, int noOfWorkingDays, int year,int empId) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		
		PreparedStatement p = connect.prepareStatement("insert into TimeSheet values(?,?,?,?)");
		p.setInt(1, empId);
		p.setInt(2, month);
		p.setInt(3, year);
		p.setInt(4, noOfWorkingDays);
		
		
		int i = p.executeUpdate();
		
		p.close();
		connect.close();
		if(i == 0)
			return false;
		return true;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/NPCI","npci","password");
		
		
		
		
		
	}

	
}