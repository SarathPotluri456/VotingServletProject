<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="index.jsp"></jsp:include>
</head>
<body>
<center>
<c:if test="${notsuccess }">
<div style="color:red">Please Enter Valid Credentials</div>
</c:if>
<form action="./Admincheck" method="post">
<h1> Please Enter Admin Details</h1>
 Enter UserName:<input type="text" name="name"/><br><br>
 Enter Password:<input type="password" name="pass"/><br><br>
 <input type="submit" value="AdminLogin"/>
</center>
</form>
</body>
</html>