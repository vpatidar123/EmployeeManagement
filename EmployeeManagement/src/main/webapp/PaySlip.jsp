<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</head>
<body>
         <h1>Welcome  
           <% 
             out.println(session.getAttribute("empName"));
           %>
           </h1>
         <h5>Employee No:
         <%
           int empId = (int)session.getAttribute("empId");
           out.println(empId);
         %>
         </h5>
        <h5>Name:
        <%
           String empName = (String)session.getAttribute("empName");
           out.println(empName);
         %>
         </h5>
        <h5>Department :
        <%
           String departmentName = (String)session.getAttribute("departmentName");
           out.println(departmentName);
         %>
         </h5>
        
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Serial No.</th>
                <th scope="col">Salary Head</th>
                <th scope="col">Amount(Rs.)</th>
                <th scope="col">Serial No.</th>
                <th scope="col">Salary Head</th>
                <th scope="col">Amount(Rs.)</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Basic</td>
                <td>
                <%
                out.println(session.getAttribute("basic"));
                %>
                </td>
                <th scope="row">4</th>
                <td>Deduction</td>
                <td><%
                out.println(session.getAttribute("deduction"));
                %>
                </td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Dearness Allowance</td>
                <td> <%
                out.println(session.getAttribute("dearnessAllowance"));
                %></td>
                <th scope="row"></th>
                <td></td>
                <td> </td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td >House Rent Allowance</td>
                <td>
                 <%
                out.println(session.getAttribute("houseRentAllowance"));
                %>
                </td>
                <th scope="row"></th>
                <td></td>
                <td> </td>
              </tr>
              <tr>
                <th scope="row"></th>
                <td ><span style="color:green;">Total salary</span></td>
                <td><span style="color:green;">
                 <%
                out.println(session.getAttribute("totalSalary"));
                %></span>
                </td>
                
              </tr>
            </tbody>
          </table>
          <form action="Logout" method="get">
                <input class="btn btn-primary" type="submit" value="Logout">
                </form>
                <br>
                <form action="Time Sheet.jsp" method="get">
                <input class="btn btn-primary" type="submit" value="Home">
                </form>
        
</body>
</html>