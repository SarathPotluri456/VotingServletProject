<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="index.jsp"></jsp:include>
</head>
<body>
<center>
<form action="./partyServlet" method="post">
    TDP:<input type="radio" name="party" value="TDP"/>
    YSRCP:<input type="radio" name="party" value="YSRCP"/>
    BJP:<input type="radio" name="party" value="BJP"/>
    JANASENA:<input type="radio" name="party" value="JANASENA"/>
    <input type="submit" value="VOTE"/>
    </form>
    
</center>
</body>
</html>