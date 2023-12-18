<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.Beans.user"%>
<%@page import="com.DAO.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
    <nav class="navbar">
    <div class="container">
      <h1>User Management System</h1>
    </div>
  </nav>

  <div class="container">
    <h2>List Of Users</h2>
    <a href="AddUser.jsp"><button class="add-user-btn">Add New User</button></a>
    <form action="ShowServlet" method="post"><button class="add-user-btn" style="background-color: darkmagenta;">Show All Users</button></form>
    <table class="user-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Country</th>
          <th>Password</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <!-- Data will be dynamically populated here -->
    <%-- Use JSP/EL to populate data from the retrieved list --%>
    <%
      List<user> userList = (List<user>) request.getAttribute("userList");
      if (userList != null) {
        for (user currentUser : userList) {
    %>
          <tr>
            <td><%= currentUser.getId() %></td>
            <td><%= currentUser.getName() %></td>
            <td><%= currentUser.getEmail() %></td>
            <td><%= currentUser.getCountry() %></td>
            <td><%= currentUser.getPassword() %></td>
            <td>
              <form action="EditServlet" method="post" style="display: inline;">
                <input type="hidden" name="id" value="<%= currentUser.getId() %>">
               <button type="submit" class="edit-btn">Edit</button>
              </form>
              <form action="DeleteServlet" method="post" style="display: inline;">
                <input type="hidden" name="id" value="<%= currentUser.getId() %>">
                <button type="submit" class="delete-btn">Delete</button>
              </form>
            </td>
          </tr>
    <%    
        }
      }
    %>
      </tbody>
    </table>
  </div>
</body>
</html>