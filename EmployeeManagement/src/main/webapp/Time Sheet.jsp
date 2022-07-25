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
      <h1 style="color:red; justify-content:center;">Welcome  
           <% 
           out.println(session.getAttribute("empName"));
           %>
           </h1>
            <div class="container">
                <div class="row">
                  <div class="col" >
                   <h2>TimeSheet</h2>
                    <form action="TimeSheet" method="post">
                        <div class="input-group mb-3">
                            <select class="form-select" id="inputGroupSelect02" name="Month">
                             <option value="1">1</option>
                              <option value="2">2</option>
                              <option value="3">3</option>
                              <option value="4">4</option>
                              <option value="5">5</option>
                              <option value="6">6</option>
                              <option value="7">7</option>
                              <option value="8">8</option>
                              <option value="9">9</option>
                              <option value="10">10</option>
                              <option value="11">11</option>
                              <option value="12">12</option>
                            </select>
                            <label class="input-group-text" for="inputGroupSelect02">Month</label>
                          </div>
                           <div class="input-group mb-3">
                        <select class="form-select" id="inputGroupSelect02" name="YearTimeSheet">
                          <option value="2022">2022</option>
                          <option value="2021">2021</option>
                          <option value="2020">2020</option>
                          <option value="2019">2019</option>
                        </select>
                        <label class="input-group-text" for="inputGroupSelect02">Year</label>
                      </div>
                          <div class="input-group mb-3">
                            <select class="form-select" id="inputGroupSelect02" name="No_of_working_days">
                              <option value="1">1</option>
                              <option value="2">2</option>
                              <option value="3">3</option>
                              <option value="4">4</option>
                              <option value="5">5</option>
                              <option value="6">6</option>
                              <option value="7">7</option>
                              <option value="8">8</option>
                              <option value="9">9</option>
                              <option value="10">10</option>
                              <option value="11">11</option>
                              <option value="12">12</option>
                              <option value="13">13</option>
                              <option value="14">14</option>
                              <option value="15">15</option>
                              <option value="16">16</option>
                              <option value="17">17</option>
                              <option value="18">18</option>
                              <option value="19">19</option>
                              <option value="20">20</option>
                              <option value="21">21</option>
                              <option value="22">22</option>
                              <option value="23">23</option>
                              <option value="24">24</option>
                              <option value="25">25</option>
                              <option value="26">26</option>
                              <option value="27">27</option>
                              <option value="28">28</option>
                              <option value="29">29</option>
                              <option value="30">30</option>
                              <option value="31">31</option>
                            </select>
                            <label class="input-group-text" for="inputGroupSelect02">No_of_working_Days</label>
                          </div>
                          <input class="btn btn-primary" type="submit" value="update">
                     </form>
                     <h3 style="color:red;"> 
                     <%
                        out.println(session.getAttribute("msg"));
                     %>
                     </h3>
                  </div>
                  <div class="col">
                  <h2>PaySlip</h2>
                   <form action="PaySlip" method="post">
                    <div class="input-group mb-3">
                        <select class="form-select" id="inputGroupSelect02" name="Month">
                         <option value="1">1</option>
                              <option value="2">2</option>
                              <option value="3">3</option>
                              <option value="4">4</option>
                              <option value="5">5</option>
                              <option value="6">6</option>
                              <option value="7">7</option>
                              <option value="8">8</option>
                              <option value="9">9</option>
                              <option value="10">10</option>
                              <option value="11">11</option>
                              <option value="12">12</option>
                        </select>
                        <label class="input-group-text" for="inputGroupSelect02">Month</label>
                      </div>
                      <div class="input-group mb-3">
                        <select class="form-select" id="inputGroupSelect02" name="Year">
                          <option value="2022">2022</option>
                          <option value="2021">2021</option>
                          <option value="2020">2020</option>
                          <option value="2019">2019</option>
                        </select>
                        <label class="input-group-text" for="inputGroupSelect02">Year</label>
                      </div>
                      <input class="btn btn-primary" type="submit" value="Generate">
                 </form>
                  </div>
                  
                </div>
              </div>
               <form action="Logout" method="get">
                <input class="btn btn-primary" type="submit" value="Logout">
                </form>
              
</body>
</html>