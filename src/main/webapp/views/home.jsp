<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>

  <h1>${detailUser.id}</h1>   

<div class="container">
  <h2>Thêm nhân viên mới</h2>
  <form action="addUser">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control"  placeholder="Enter email" name="email">
    </div>
    
    <div class="form-group">
      <label for="email">FistName:</label>
      <input type="text" class="form-control"  placeholder="FistName" name="firstname">
    </div>
    
    <div class="form-group">
      <label for="email">LastName:</label>
      <input type="text" class="form-control"  placeholder="FistName" name="lastname">
    </div>
    
   
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

      <table  class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">email</th>
		<th>Xoa</th>
		<th>Sua</th>
	
    </tr>
  </thead>
  <tbody>
  <c:forEach var = "i" items="${listUser}" >
     <tr>
      <td>${i.id}</td>
      <td>${i.firstname}</td>
      <td>${i.lastname}</td>
      <td>${i.email}</td>
      
      <td><a href="DeleteUser?id=${i.id}" class="btn btn-primary">delete</a></td> 
      

      
      <td><a href="DetailUser?id=${i.id}" class="btn btn-primary" >Update</a></td> 
    </tr>
      </c:forEach>
  </tbody>
</table>
      
  
      
</body>
</html>