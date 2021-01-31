<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<br>
<form action="login" method="post">
    User Name: <input type="text" value="${cookie.user.value}"
                      name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    Remember Me: <input type="checkbox"
                        <c:if test="${cookie.containsKey('user')}">checked</c:if> name="remember" value="yes"><br/>
    <input type="submit">
</form>
${user}
</br>
${err_msg}
<span style="color: #ff0000">${err_msg}</span>
</body>
</html>