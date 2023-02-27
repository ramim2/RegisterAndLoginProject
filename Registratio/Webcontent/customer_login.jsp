<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body bgcolor="green">
<div align=center>
<h1>Customer Login Page</h1>
</div>
    <form action="logCustomer" method="post">
    

    <table>
    <tr><td>Enter Email:</td><td>
    <input type="email" name="tbemail" id="tbemail"
    value ="<%=request.getParameter("tbemail")%>"/></td></tr>
   
    
    <tr><td>Enter Password:</td><td> 
    <input type="password" name="tbpass" id="tbpass"
    value ="<%=request.getParameter("tbpass")%>"/></td></tr>
    
    <tr><td><input type="submit" value="Login"/></td></tr>
    </table>
</form>
</body>
</html>