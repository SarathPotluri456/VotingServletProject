<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voter Registration</title>
<jsp:include page="index.jsp"></jsp:include>
</head>
<body>
<center>
<c:if test="${notsuccess }">
<div style="color:red">Your Data Not Submitted Successfully</div>
</c:if>
<form action="./voterRegister" method="post">
<h1>Please Enter Voter Details</h1>
Enter VoterId:<input type="text" name="id"/><br><br>
Enter VoterName:<input type="text" name="name"/><br><br>
Enter Gender:<input type="radio" id="male" name="gen" value="male"/>Male
<input type="radio" id="female" name="gen" value="female"/>Female
<input type="radio"  id="others" name="gen" value="others"/>Others<br></br>
Enter Address:<input type="text" name="addr"/><br><br>
<input type="submit" value="VoterRegistration"/>
</form>
</center>
</body>
</html>