<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<h1>Customer Registration</h1>


<form action="regcustomer" method="post">
Name:<input type="text" name="tbname" id="tbname"/>
<br>

Email:<input type="email" name="tbemail" id="tbemail"/>
<br>

Mobile:<input type="tel" name="tbMobile" id="tbmobile"/>
<br>



State:<select name="ddlStates">
<option value="Karnataka">KA</option>
<option value="Andhra Pradesh">AP</option>
<option value="Tamil Nadu">TM</option>
</select>
<br>

Password:<input type="password" name="tbpass" id="tbpass">
<br>

<input type="submit" value="register"/>

</form>

</body>
</html>