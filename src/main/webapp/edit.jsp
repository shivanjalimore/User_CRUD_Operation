<%@ page import="com.Beans.user" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="AddUser.css">
</head>
<body>

   <%
   user existingUser = (user) request.getAttribute("existingUser");
   %>
       <div class="container">
      <h1> Edit User Registration Form</h1>
    <form id="registrationForm" action="UpdateServlet" method="post">
    
     <input type="hidden" id="id" name="id" value="<%= existingUser != null ? existingUser.getId() : "" %>">
       <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= existingUser != null ? existingUser.getName() : "" %>">
      </div>
      <div class="form-group">
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" value="<%= existingUser != null ? existingUser.getEmail() : "" %>">
      </div>
      <div class="form-group">
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" value="<%= existingUser != null ? existingUser.getCountry() : "" %>">
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="<%= existingUser != null ? existingUser.getPassword() : "" %>">
      </div>
      <button type="submit" style="background-color: red;">Edit</button>
    </form>
  </div>
</body>
</html>