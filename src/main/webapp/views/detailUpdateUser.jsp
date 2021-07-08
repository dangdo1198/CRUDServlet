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









<form action="updateController" method="get">
  
    
    <input type="text" class="form-control"  name="id" value="${detailUser.id}"readonly="readonly">
 

    <input type="text" class="form-control"  name="firstname" value="${detailUser.firstname}">


    
    <input type="text" class="form-control"  name="lastname"  value="${detailUser.lastname}">

   
    <input type="text" class="form-control"  name="email"  value="${detailUser.email}">

 
  <button type="submit" class="btn btn-default">Submit</button>
</form>



</body>
</html>